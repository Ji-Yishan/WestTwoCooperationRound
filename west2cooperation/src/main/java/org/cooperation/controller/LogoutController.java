package org.cooperation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String logout(HttpSession session) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str=mapper.writeValueAsString("退出登录");
        session.invalidate();
        return str;


    }
}