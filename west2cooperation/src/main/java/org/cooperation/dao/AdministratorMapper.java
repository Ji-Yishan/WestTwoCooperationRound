package org.cooperation.dao;

import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    int auditProject(@Param("pid") String pid,@Param("audit") int audit);
    int deleteProject( String pid);


}
