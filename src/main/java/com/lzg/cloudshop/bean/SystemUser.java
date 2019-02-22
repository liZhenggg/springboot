package com.lzg.cloudshop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SystemUser {
    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    private String phoneNum;

    private Boolean isBlack;

    public SystemUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Boolean getBlack() {
        return isBlack;
    }

    public void setBlack(Boolean black) {
        isBlack = black;
    }
}
