package org.cooperation.controller;

import org.cooperation.pojo.Project;
import org.cooperation.service.ProjectService;
import org.cooperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("ProjectServiceImpl")
    private ProjectService projectService ;
    int pageSize=10;
    int curpage;
    int curPage=(curpage-1)*pageSize;
    String username="不要早八";
    @RequestMapping("/select")
    public String selectProject(Model model,int curpage){
        List<Project> list=projectService.selectProject(curPage,pageSize);
        model.addAttribute("msg",list);
        return "show";
    }
    @RequestMapping("/update")
    public String updateProject(Model model){
        String username=this.username;
        Project project=new Project("人为什么要早起","","我爬不起来，救救我",5,username);
        projectService.updateProject(project);
        model.addAttribute("msg","更新成功");
        return "show";
    }
    @RequestMapping("/add")
    public String addProject(Model model,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        fileUpload2(file,request);
        Project project=new Project("怨种大学生起不来床","path","希望起床能有点盼头",1,"sleep");
        projectService.addProject(project);
        model.addAttribute("msg","添加成功");
        return "show";
    }
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

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

        return "redirect:/index.jsp";
    }
    @RequestMapping("/delete")
    public String deleteProject(Model model){
        projectService.deleteProject("人为什么要早起","不要早八");
        model.addAttribute("msg","删除成功");
        return "show";
    }
    @RequestMapping("/queryFund")
    public String queryCurrentFund(Model model){
        int fund=projectService.queryCurrentFund("怨种大学生起不来床","sleep");
        model.addAttribute("msg",fund);
        return "show";
    }
    @RequestMapping("/updateFund")
    public String updateCurrentFund(Model model){
        projectService.updateCurrentFund(1,"怨种大学生起不来床","sleep");
        model.addAttribute("msg","更新成功");
        return "show";
    }
    @RequestMapping("/query")
    public String queryProjectByName(Model model,int curPage){
        List<Project> list =projectService.queryProjectByName("怨种大学生起不来床",curPage,pageSize);
        model.addAttribute("msg",list);
        return "show";
    }
    @RequestMapping("/audit")
    public String queryAudit(Model model){
        int audit=projectService.queryAudit("怨种大学生起不来床","sleep");
        model.addAttribute("msg",audit);
        return "show";
    }
}
