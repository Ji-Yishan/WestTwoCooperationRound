package org.cooperation.dao;

import org.apache.ibatis.annotations.Param;
import org.cooperation.pojo.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    List<Project> selectProject(@Param("curPage") int curPage,@Param("pageSize") int pageSize);
    int updateProject(Project project);
    int addProject(Project project);
    int deleteProject(@Param("username") String username,@Param("pname") String pname);
    Map queryCurrentFund(String pid);
    Map queryAudit(String pid);
    int updateCurrentFund(@Param("fund") int fund,@Param("pid") String pid);
    String queryUUID(@Param("pname") String pname,@Param("username") String username);
    List<Project> queryProjectByName(@Param("pname") String pname);
}
