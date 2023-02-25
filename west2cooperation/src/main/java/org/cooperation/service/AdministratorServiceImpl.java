package org.cooperation.service;

import org.cooperation.dao.AdministratorMapper;

public class AdministratorServiceImpl implements AdministratorService{
    private AdministratorMapper administratorMapper;
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }


    public int auditProject(String pname, String username, int audit) {
        return administratorMapper.auditProject(pname,username,audit);
    }

    public int deleteProject(String pname, String username) {
        return administratorMapper.deleteProject(pname,username);
    }
}
