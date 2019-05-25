package com.neuedu.JavaItems.Dao;

import com.neuedu.JavaItems.DataSource.DruidDataSource;
import com.neuedu.JavaItems.pojo.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductImpl implements ProInterace{

//拿到连接池
 DruidDataSource ds = DruidDataSource.getDataSource();

 //拿到QuerryRunner对象
    private QueryRunner qr;
  public ProductImpl()
  {
      qr = new QueryRunner();
  }


//添加商品
    @Override
    public void addOnePro(Product pro) {
        Connection conn = ds.getConnection();
        String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(conn,sql,pro.getPro_id(),pro.getPro_name(),pro.getPro_price(),pro.getPro_image(),pro.getPro_des(),pro.getPro_stock(),pro.getPro_date(),pro.getPro_cate_id(),pro.getPro_factory());
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

//删除商品
    @Override
    public void delOnePro(String pro_id) {
        Connection conn = ds.getConnection();
        String sql = "DELETE FROM product WHERE pro_id=?";
        try {
            qr.update(conn,sql,pro_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//查询商品

    @Override
    public List<Product> getAllPro() {
        Connection conn = ds.getConnection();
        String sql = "SELECT * FROM product";
        List<Product> query = null;
        try {
          query = qr.query(conn, sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return query;
    }


}
