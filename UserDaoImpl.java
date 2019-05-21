package com.neuedu.dao;

import com.neuedu.pojo.User;
import com.neuedu.utils.DBUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {




    //注册
    @Override
    public void regsiter(String user, String psw) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO User (username,pasd) VALUES (?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, psw);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closerpstm(pstm);
            DBUtils.closeConnection(conn);
        }
    }

    //登陆
//    @Override
//    public boolean login(String user, String psw) {
//        Connection conn = null;
//        PreparedStatement pstam = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnertion();
//            String sql = "SELECT  username,pasd FROM User GROUP BY id";
//            pstam = conn.prepareStatement(sql);
//            rs = pstam.executeQuery();
//            while (rs.next()){
//                String username = rs.getString("username");
//                String pasd = rs.getString("pasd");
//                if (username.equals(user) && pasd.equals(psw)){
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DBUtils.closerrs(rs);
//            DBUtils.closerpstm(pstam);
//            DBUtils.closeConnection(conn);
//        }
//        return  false;
//    }

    @Override
        public User login(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT  username,pasd FROM User WHERE username=? AND pasd=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            rs = pstm.executeQuery();
           if (rs.next()){
               return user;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closerrs(rs);
            DBUtils.closerpstm(pstm);
            DBUtils.closeConnection(conn);
        }

        return null;
    }

    @Override
    public void update(User user) {

        Connection conn =null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE User SET pasd=? WHERE username=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getPassword());
            pstm.setString(2,user.getUsername());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //MD5加密
//    @Override
//    public String getMD5String(String str) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(str.getBytes());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}