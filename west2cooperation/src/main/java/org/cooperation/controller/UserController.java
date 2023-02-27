package org.cooperation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.cooperation.pojo.User;
import org.cooperation.service.UserService;
import org.cooperation.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
@Qualifier("UserServiceImpl")
    private UserService userService ;



//    @RequestMapping("/select")
//    public String selectUser(Model model){
//        List<User> list=userService.selectUser();
//        model.addAttribute("msg",list);
//    for(User user:list){
//        System.out.println(user);
//
//         }
//    return "show";
//    }


    @RequestMapping("/update")
    public void updateUser(HttpSession session, HttpServletRequest req){
        String userid=session.getAttribute("userid").toString();
        String contact=req.getParameter("Connect").toString();
        String idcard=req.getParameter("id");
        String username=req.getParameter("Name").toString();
        User user=new User(userid,username,contact,idcard);
        userService.updateUser(user);
    }
    private static Map<Integer, String> usermap = null;
    @ResponseBody
    @RequestMapping("/profile")
    public String queryUserByName(Model model,HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userid=session.getAttribute("userid").toString();
        Map user=userService.queryProfile(userid);
        String str3=mapper.writeValueAsString(user);
        return str3;


    }
//    @RequestMapping("/degree")
//    public String queryDegree(Model model){
//        int degree=userService.queryDegree("username");
//        model.addAttribute("msg",degree);
//        return "show";
//    }

}
