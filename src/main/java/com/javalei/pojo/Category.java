package com.javalei.pojo;

public class Category {
    private Integer cid;

    private String cname;

    private Integer userid;

    public Category(Integer cid, String cname, Integer userid) {
        this.cid = cid;
        this.cname = cname;
        this.userid = userid;
    }

    public Category() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}