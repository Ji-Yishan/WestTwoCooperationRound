package org.cooperation.dao;

import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    int auditProject(@Param("pname") String pname, @Param("username") String username,@Param("audit") int audit);
    int deleteProject(@Param("pname") String pname,@Param("username") String username);


}
