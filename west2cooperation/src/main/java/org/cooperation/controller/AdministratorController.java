package org.cooperation.controller;

import org.cooperation.service.AdministratorService;
import org.cooperation.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    @Qualifier("AdministratorServiceImpl")
    private AdministratorService administratorService ;
    @RequestMapping("/audit")
    public String auditProject(Model model){
        administratorService.auditProject("怨种大学生起不来床","sleep",1);
        model.addAttribute("msg","审核成功");
        return "show";
    }
    @RequestMapping("/delete")
    public String deleteProject(Model model){
        administratorService.deleteProject("aba","ab");
        model.addAttribute("msg","删除成功");
        return "show";
    }
}
