package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface Userdao {

//查询
    List<User> getAllUser();


//修改
    void update(User user);
}
