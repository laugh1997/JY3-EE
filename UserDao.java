package com.neuedu.dao;

import com.neuedu.pojo.User;

/*
* UserDao接口
* */
public interface UserDao {

//注册
    void regsiter(String user,String psw);

//登陆
//    boolean login(String user,String psw);
        User login(User user);

//修改
    void update(User user);

//加密
//   String getMD5String(String str);

}
