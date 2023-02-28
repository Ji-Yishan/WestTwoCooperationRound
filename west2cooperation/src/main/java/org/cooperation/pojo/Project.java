package org.cooperation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Project {
    private String pname;
    private String pLocation;
    private String content;
    private int targetFund;
    private int fund;
    private int audit;
    private String username;
    private int pageSize;
    private String pid;

    @Override
    public String toString() {
        return "Project{" +
                "pname='" + pname + '\'' +
                ", pLocation='" + pLocation + '\'' +
                ", content='" + content + '\'' +
                ", targetFund=" + targetFund +
                ", fund=" + fund +
                ", audit=" + audit +
                ", username='" + username + '\'' +
                '}';
    }

    public Project(String pname, String pLocation, String content, int targetFund, int fund, int audit, String username,String pid) {
        this.pname = pname;
        this.pLocation = pLocation;
        this.content = content;
        this.targetFund = targetFund;
        this.fund = fund;
        this.audit = audit;
        this.username = username;
        this.pid=pid;
    }
    public Project(String pid,String pname, String content, int targetFund,String username){
        this.pname = pname;
        this.pid=pid;
//        this.pLocation = pLocation;
        this.content = content;
        this.targetFund = targetFund;
        this.username = username;
    }

    public Project(String pname,String username){
        this.pname = pname;
        this.username = username;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getpLocation() {
        return pLocation;
    }

    public void setpLocation(String pLocation) {
        this.pLocation = pLocation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(int targetFund) {
        this.targetFund = targetFund;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
