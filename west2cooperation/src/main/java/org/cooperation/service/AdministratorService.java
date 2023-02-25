package org.cooperation.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {
    int auditProject(@Param("pname") String pname, @Param("username") String username, @Param("audit") int audit);
    int deleteProject(@Param("pname") String pname,@Param("username") String username);
}
