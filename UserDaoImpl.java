package com.neuedu.dao;

import com.neuedu.DataSource.DruidDataSource;
import com.neuedu.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements Userdao{

    private QueryRunner qr = null;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDaoImpl()
    {
    qr = new QueryRunner();
    }


    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM User";
        List<User> users = null;
       Connection conn = dds.getConnection();
        try {
           users = qr.query(conn, sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

//修改
    @Override
    public void update(User user) {
     String sql = "UPDATE User SET username=? pasd=? WHERE id=?";
        Connection connection = dds.getConnection();
        try {
            qr.update(connection,sql,user.getUsername(),user.getPasd(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
