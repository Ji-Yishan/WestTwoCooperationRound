package org.cooperation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.cooperation.pojo.Project;
import org.cooperation.service.ProjectService;
import org.cooperation.service.UserService;
import org.cooperation.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("ProjectServiceImpl")
    private ProjectService projectService ;
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;
    int pageSize=10;


    @GetMapping("/select/{curPage}")
    @ResponseBody
    public String selectProject(@PathVariable int curPage, HttpSession session, HttpServletRequest req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
         curPage=(curPage-1)*pageSize;
        List<Project> project=projectService.selectProject(curPage,10);

        String str=mapper.writeValueAsString(project);
        return str;
    }

    @PutMapping(value = "/add/{pname}/{reason}/{need}/{inId}")
    @ResponseBody
    public void addProject( HttpServletRequest request, HttpServletResponse response,
                           @PathVariable String pname, @PathVariable String reason, @PathVariable int need, @PathVariable String inId) throws IOException {
        String pid= UUID.getUUID();
        response.setContentType("multipart/form-data");
        String username=request.getSession().getAttribute("username").toString();
        List<String> ids=userService.queryId(username);
        for(String id: ids){
            if( id.equals(inId)){
                Project project=new Project(pid,pname,reason,need,username);
                projectService.addProject(project);
            }
        }


    }
    @ResponseBody
    @PostMapping("/picture/{pname}")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file, @PathVariable("pname") String pname,
                               HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        ObjectMapper mapper = new ObjectMapper();
        String username=request.getSession().getAttribute("username").toString();
        String pid=projectService.queryUUID(pname,username);
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println(path);
        System.out.println("上传文件保存地址："+realPath);
        projectService.setPlocation(path,pid);
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));
        String str=mapper.writeValueAsString(path);
        return str;
    }
    @DeleteMapping("/delete/{pid}")
    public void deleteProject(@PathVariable String pid){
        projectService.deleteProject(pid);
    }
    @GetMapping("/queryFund/{pid}")
    @ResponseBody
    public String queryCurrentFund(@PathVariable String pid) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map fund=projectService.queryCurrentFund(pid);
        String str=mapper.writeValueAsString(fund);
        return str;
    }
    @PutMapping("/updateFund/{fund}/{pid}")
    public void updateCurrentFund(@PathVariable int fund,@PathVariable String pid,HttpServletRequest req){
        projectService.updateCurrentFund(fund,pid);


    }
    @GetMapping("/query/{name}")
    @ResponseBody
    public String queryProjectByName(@PathVariable String name) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        name="%"+name+"%";
        List<Project> list =projectService.queryProjectByName(name);
        String str=mapper.writeValueAsString(list);
        return str;
    }
    @GetMapping("/audit/{pid}")
    @ResponseBody
    public String queryAudit(@PathVariable String pid) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map audit=projectService.queryAudit(pid);
        String str=mapper.writeValueAsString(audit);
        return str;
    }
    //    @RequestMapping("/update")
//    public String updateProject(Model model,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
//        String f=fileUpload2(file,request);
//        String username=this.username;
//        Project project=new Project("人为什么要早起",f,"我爬不起来，救救我",5,username);
//        projectService.updateProject(project);
//        model.addAttribute("msg","更新成功");
//        return "show";
//    }
}
