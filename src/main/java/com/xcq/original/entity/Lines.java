package com.xcq.original.entity;

import java.util.Date;

public class Lines {

    private Integer id ;
    private String token;
    private String name;
    private String info;
    private Date this_time;
    private Integer count;
    private Date last_time;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getThis_time() {
        return this_time;
    }

    public void setThis_time(Date this_time) {
        this.this_time = this_time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", this_time=" + this_time +
                ", count=" + count +
                ", last_time=" + last_time +
                ", memo='" + memo + '\'' +
                '}';
    }
}
