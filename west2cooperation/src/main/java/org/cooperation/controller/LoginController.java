package org.cooperation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cooperation.pojo.User;
import org.cooperation.service.UserService;
import org.cooperation.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @GetMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(HttpSession session, HttpServletRequest req) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String str = "";
        List<User> userList = userService.queryUserByName(username);
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                ObjectMapper mapper = new ObjectMapper();
                str=mapper.writeValueAsString(user);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                String userid=userService.queryUUID(username,password);
                int degree=userService.queryDegree(userid);
                session.setAttribute("degree",degree);
                session.setAttribute("userid",userid);
                return str;
            }
        }
        return str;
    }
    @GetMapping("/add")
    @ResponseBody
    public String addUser(HttpSession session, HttpServletRequest req) throws JsonProcessingException {
        String username=req.getParameter("reg_username");
        String password=req.getParameter("reg_password");
        String userid= UUID.getUUID();
        User user=new User(username,password,userid);
        userService.addUser(user);
        session.setAttribute("userid",userid);
        session.setAttribute("username",username);
        ObjectMapper mapper = new ObjectMapper();
        String str=mapper.writeValueAsString(user);
        return str;
    }
}
