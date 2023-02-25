package org.cooperation.dao;

import org.apache.ibatis.annotations.Param;
import org.cooperation.pojo.Project;

import java.util.List;

public interface ProjectMapper {
    List<Project> selectProject(@Param("curPage") int curPage,@Param("pageSize") int pageSize);
    int updateProject(Project project);
    int addProject(Project project);
    int deleteProject(@Param("pname") String pname,@Param("username") String username);
    int queryCurrentFund(@Param("pname") String pname,@Param("username") String username);
    int queryAudit(@Param("pname") String pname,@Param("username") String username);
    int updateCurrentFund(@Param("fund") int fund,@Param("pname") String pname,@Param("username") String username);
    List<Project> queryProjectByName(@Param("pname") String pname,@Param("curPage") int curPage,@Param("pageSize") int pageSize);
}
