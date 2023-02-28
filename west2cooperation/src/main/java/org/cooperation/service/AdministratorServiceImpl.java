package org.cooperation.service;

import org.cooperation.dao.AdministratorMapper;

public class AdministratorServiceImpl implements AdministratorService{
    private AdministratorMapper administratorMapper;
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }


    public int auditProject(String pid, int audit) {
        return administratorMapper.auditProject(pid,audit);
    }

    public int deleteProject(String pid) {
        return administratorMapper.deleteProject(pid);
    }
}
