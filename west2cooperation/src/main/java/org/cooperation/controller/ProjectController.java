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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    int curpage;
    int curPage=(curpage-1)*pageSize;
    String username="不要早八";
    @RequestMapping("/select")
    @ResponseBody
    public String selectProject(HttpSession session, HttpServletRequest req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int curPage1=Integer.parseInt(req.getParameter("curPage"));
        int curPage=(curPage1-1)*pageSize;
        List<Project> project=projectService.selectProject(curPage,10);
        String str=mapper.writeValueAsString(project);
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
    @RequestMapping("/add")
    public void addProject(Model model, HttpServletRequest request) throws IOException {
        String pid= UUID.getUUID();
        String pname=request.getParameter("fundname");
        String content=request.getParameter("inforreason");
        int targetFund=Integer.parseInt(request.getParameter("need"));
        String username=request.getSession().getAttribute("username").toString();
        String inId=request.getParameter("id");
        String id=userService.queryId(username);
        if(id.equals(inId)){
            Project project=new Project(pid,pname,content,targetFund,username);
            projectService.addProject(project);
        }

        ObjectMapper mapper = new ObjectMapper();

    }
    @RequestMapping("/picture")
    public String  fileUpload2(@RequestParam("inforimag") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("jiijijijiji");
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));
        String f=realPath.toString();
        return f;
    }
    @RequestMapping("/delete")
    public void deleteProject(HttpServletRequest req,HttpSession session){
        String pname=req.getParameter("id");
        String username=req.getParameter("username");
        projectService.deleteProject(username,pname);
    }
//    @RequestMapping("/check")
//    @ResponseBody
//    public boolean queryId(HttpServletRequest req,HttpSession session){
//        String inId=req.getParameter("account");
//        String username=session.getAttribute("username").toString();
//        String id=userService.queryId(username);
//        if(id.equals(inId)){
//            return true;
//        }
//        return false;
//    }
    @RequestMapping("/queryFund")
    @ResponseBody
    public String queryCurrentFund(Model model,HttpServletRequest req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String pname=req.getParameter("raise");
        String username=req.getParameter("id");
        String pid=projectService.queryUUID(pname,username);
        Map fund=projectService.queryCurrentFund(pid);
        String str=mapper.writeValueAsString(fund);
        return str;
    }
    @RequestMapping("/updateFund")
    public void updateCurrentFund(Model model,HttpServletRequest req){
        int fund=Integer.parseInt(req.getParameter("money"));
        String pname=req.getParameter("id");
        String username=req.getParameter("username");
        String pid=projectService.queryUUID(pname,username);
        projectService.updateCurrentFund(fund,pid);


    }
    @RequestMapping("/query")
    @ResponseBody
    public String queryProjectByName(Model model,HttpServletRequest req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String username=req.getParameter("name");
        username="%"+username+"%";
        List<Project> list =projectService.queryProjectByName(username);
        String str=mapper.writeValueAsString(list);
        return str;
    }
    @RequestMapping("/audit")
    @ResponseBody
    public String queryAudit(Model model,HttpServletRequest req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String username=req.getParameter("username");
        String pname=req.getParameter("pname");
        String pid=projectService.queryUUID(pname,username);
        Map audit=projectService.queryAudit(pid);
        String str=mapper.writeValueAsString(audit);
        return str;
    }
}
