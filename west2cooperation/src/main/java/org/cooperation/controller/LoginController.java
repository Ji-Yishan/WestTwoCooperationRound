package org.cooperation.controller;

import org.cooperation.pojo.User;
import org.cooperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;
    @RequestMapping("/login")
    public String login(Model model, HttpSession session, String username, String password){
        username="不要早八";
        password="123456";
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        List<User> userList=userService.queryUserByName(username);
        boolean lgoin=false;
        for (User user:userList){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                lgoin=true;
                model.addAttribute("msg","登录成功");
            }
        }
        if(lgoin==false){
            model.addAttribute("msg","登录失败");
        }
        return "show";
    }
    @RequestMapping("/jumpLogin")
    public String jumpToLogin(){
        return "login";
    }
    @RequestMapping("/jumpSuccess")
    public String jumpToSuccess(){
        return "success";
    }
}
