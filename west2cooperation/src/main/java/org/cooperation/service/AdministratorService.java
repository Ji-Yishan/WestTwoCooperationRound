package org.cooperation.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {
    int auditProject(@Param("pid") String pid, @Param("audit") int audit);
    int deleteProject( String pid);
}
