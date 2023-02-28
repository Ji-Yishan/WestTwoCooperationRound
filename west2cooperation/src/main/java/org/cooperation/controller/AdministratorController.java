package org.cooperation.controller;

import org.cooperation.service.AdministratorService;
import org.cooperation.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    @Qualifier("AdministratorServiceImpl")
    private AdministratorService administratorService ;
    @PutMapping("/audit/{pid}/{audit}")
    public void auditProject(@PathVariable String pid,@PathVariable int audit, HttpSession session){
        int degree=Integer.parseInt(session.getAttribute("degree").toString());
        if(degree==1){
            administratorService.auditProject(pid,audit);
         }
    }
    @DeleteMapping("/delete/{pid}")
    public void deleteProject(@PathVariable String pid){
        administratorService.deleteProject(pid);

    }
}
