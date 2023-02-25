package org.cooperation.service;

import org.cooperation.pojo.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> selectProject(int curPage,int pageSize);
    int updateProject(Project project);
    int addProject(Project project);
    int deleteProject(String pname,String username);
    int queryCurrentFund(String pname,String username);

    int updateCurrentFund(int fund,String pname,String username);
    List<Project> queryProjectByName(String pname,int curPage,int pageSize);
    int queryAudit(String pname,String username);
}
