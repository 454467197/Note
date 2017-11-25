package com.javalei.pojo;

import java.util.Date;

public class Detailed {
    private Integer id;

    private String dname;

    private String content;

    private Integer state;

    private Date createtime;

    private Date createdate;

    private Integer cid;

    private Integer userid;

    private Integer isfile;

    public Detailed(Integer id, String dname, String content, Integer state, Date createtime, Date createdate, Integer cid, Integer userid, Integer isfile) {
        this.id = id;
        this.dname = dname;
        this.content = content;
        this.state = state;
        this.createtime = createtime;
        this.createdate = createdate;
        this.cid = cid;
        this.userid = userid;
        this.isfile = isfile;
    }

    public Detailed() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIsfile() {
        return isfile;
    }

    public void setIsfile(Integer isfile) {
        this.isfile = isfile;
    }

    @Override
    public String toString() {
        return "Detailed{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createtime=" + createtime +
                ", createdate=" + createdate +
                ", cid=" + cid +
                ", userid=" + userid +
                ", isfile=" + isfile +
                '}';
    }
}