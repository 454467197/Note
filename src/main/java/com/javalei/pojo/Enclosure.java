package com.javalei.pojo;

import java.util.Date;

public class Enclosure {
    private Integer eid;

    private Integer did;

    private Integer userid;

    private String ename;

    private String epath;

    private String ip;

    private Date createtime;

    private Date createdate;

    public Enclosure(Integer eid, Integer did, Integer userid, String ename, String epath, String ip, Date createtime, Date createdate) {
        this.eid = eid;
        this.did = did;
        this.userid = userid;
        this.ename = ename;
        this.epath = epath;
        this.ip = ip;
        this.createtime = createtime;
        this.createdate = createdate;
    }

    public Enclosure() {
        super();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEpath() {
        return epath;
    }

    public void setEpath(String epath) {
        this.epath = epath == null ? null : epath.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}