package org.cooperation.controller;

import org.cooperation.service.AdministratorService;
import org.cooperation.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    @Qualifier("AdministratorServiceImpl")
    private AdministratorService administratorService ;
    @RequestMapping("/audit")
    public void auditProject(Model model, HttpServletRequest req, HttpSession session){
        int audit=Integer.parseInt(req.getParameter("audit"));
        String pname=req.getParameter("pname");
        String username=req.getParameter("username");
        int degree=Integer.parseInt(session.getAttribute("degree").toString());
        if(degree==1){
            administratorService.auditProject(pname,username,audit);
        }

    }
    @RequestMapping("/delete")
    public void deleteProject(Model model,HttpServletRequest req){
        String pname=req.getParameter("pname");
        String username=req.getParameter("username");
        administratorService.deleteProject(pname,username);

    }
}
