package org.cooperation.service;

import org.cooperation.dao.ProjectMapper;
import org.cooperation.dao.UserMapper;
import org.cooperation.pojo.Project;

import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService{
    private ProjectMapper projectMapper;
    public void setProjectMapper(ProjectMapper projectMapper){
        this.projectMapper=projectMapper;
    }
    public String queryUUID(String pname,String username){
        return projectMapper.queryUUID(pname,username);
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


    public int deleteProject(String pid) {
        return projectMapper.deleteProject(pid);
    }

    public Map queryCurrentFund(String pid) {
        return projectMapper.queryCurrentFund(pid);
    }

    public int updateCurrentFund(int fund, String pid) {
        return projectMapper.updateCurrentFund(fund,pid);
    }

    public List<Project> queryProjectByName(String pname) {
        return projectMapper.queryProjectByName(pname);
    }
    public int setPlocation(String pLocation,String pid){
        return projectMapper.setPlocation(pLocation,pid);
    }

    public Map queryAudit(String pid){
        return projectMapper.queryAudit(pid);
    }
}
