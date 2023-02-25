package org.cooperation.service;

import org.cooperation.dao.ProjectMapper;
import org.cooperation.dao.UserMapper;
import org.cooperation.pojo.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{
    private ProjectMapper projectMapper;
    public void setProjectMapper(ProjectMapper projectMapper){
        this.projectMapper=projectMapper;
    }
    public List<Project> selectProject(int curPage,int pageSize) {
        return projectMapper.selectProject(curPage,pageSize);
    }

    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    public int addProject(Project project) {
        return projectMapper.addProject(project);
    }


    public int deleteProject(String pname, String username) {
        return projectMapper.deleteProject(pname,username);
    }

    public int queryCurrentFund(String pname, String username) {
        return projectMapper.queryCurrentFund(pname,username);
    }

    public int updateCurrentFund(int fund, String pname, String username) {
        return projectMapper.updateCurrentFund(fund,pname,username);
    }

    public List<Project> queryProjectByName(String pname,int curPage,int pageSize) {
        return projectMapper.queryProjectByName(pname,curPage,pageSize);
    }

    public int queryAudit(String pname, String username){
        return projectMapper.queryAudit(pname,username);
    }
}
