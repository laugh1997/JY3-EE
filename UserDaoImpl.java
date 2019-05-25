package com.neuedu.JavaItems.Dao;

import com.neuedu.JavaItems.DataSource.DruidDataSource;
import com.neuedu.JavaItems.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImpl implements UserDao{

//拿到连接池
    DruidDataSource ds = DruidDataSource.getDataSource();

//拿到QuerryRunner对象
    private QueryRunner qr;

    public UserDaoImpl()
    {
        qr = new QueryRunner();
    }

//注册
    @Override
    public void regOneAccount(String userName, String passWord, Date addDate) {
        Connection conn = ds.getConnection();
        String sql = "INSERT INTO user (userName,PassWord,addDate) VALUES (?,?,?)";
        try {
            qr.update(conn,sql,userName,passWord,addDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//登陆
    @Override
    public boolean userLogin(String userName, String passWord) {
        Connection conn = ds.getConnection();
        String sql = "SELECT userName,passWord FROM user WHERE userName=? AND passWord=?";
        try {
            User query = qr.query(conn, sql, new BeanHandler<>(User.class), userName, passWord);
            if (query != null)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

}
