package com.neuedu.JavaItems.pojo;

import java.sql.Date;

public class User {

    private Integer id;

    private String userName;

    private String passWord;

    private Date addDate;

    public User(Integer id, String userName, String passWord, Date addDate) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.addDate = addDate;
    }


    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }


    public User()
    {

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", addDate=" + addDate +
                '}';
    }
}
