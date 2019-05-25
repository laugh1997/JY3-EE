package com.neuedu.JavaItems.Dao;

import com.neuedu.JavaItems.pojo.User;

import java.sql.Date;

public interface UserDao {

//注册
    void regOneAccount(String userName, String passWord, Date addDate);

//登陆
    boolean userLogin(String userName,String passWord);



}
