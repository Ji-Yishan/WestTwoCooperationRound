package org.cooperation.controller;

import org.apache.ibatis.annotations.Param;
import org.cooperation.pojo.User;
import org.cooperation.service.UserService;
import org.cooperation.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

@Autowired
@Qualifier("UserServiceImpl")
    private UserService userService ;
    String username="hao";


    @RequestMapping("/select")
    public String selectUser(Model model){
        List<User> list=userService.selectUser();
        model.addAttribute("msg",list);
    for(User user:list){
        System.out.println(user);

         }
    return "show";
    }

    @RequestMapping("/add")
    public String addUser(Model model){
        User user=new User("aba","12345");
        userService.addUser(user);
        model.addAttribute("msg","成功添加");
        return "show";
    }
    @RequestMapping("/update")
    public String updateUser(Model model){
        String username=this.username;
        User user=new User(username,"no",1534563,"350303030300303030");
        userService.updateUser(user);
        model.addAttribute("msg","成功更新");
        return "show";
    }
    @RequestMapping("/query")
    public String queryUserByName(Model model){
        List<User> user=userService.queryUserByName(username);
        model.addAttribute("msg",user);
        return "show";
    }
    @RequestMapping("/degree")
    public String queryDegree(Model model){
        int degree=userService.queryDegree(username);
        model.addAttribute("msg",degree);
        return "show";
    }

}
