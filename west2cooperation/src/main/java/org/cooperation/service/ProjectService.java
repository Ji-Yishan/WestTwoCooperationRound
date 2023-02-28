package org.cooperation.service;

import org.cooperation.pojo.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProjectService {
    List<Project> selectProject(int curPage,int pageSize);
    int updateProject(Project project);
    int addProject(Project project);
    String queryUUID(String pname,String username);
    int deleteProject(String pid);
    Map queryCurrentFund(String pid);

    int updateCurrentFund(int fund,String pid);
    List<Project> queryProjectByName(String pname);
    Map queryAudit(String pid);
    int setPlocation(String pLocation,String pid);
}
