package org.cooperation.controller;

import org.cooperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;
    @RequestMapping("/logout")
    public void logout(Model model, HttpSession session){
            session.invalidate();
            model.addAttribute("msg","成功退出");


    }
}