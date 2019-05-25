package com.neuedu.JavaItems.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {

//拿到resource内文件
private static Properties prop = new Properties();

private static DruidDataSource ds = null;

//构造器私有
    private  DruidDataSource()
    {

    }

//保证连接池单例
    public  static  DruidDataSource getDataSource()
    {
        if (null == ds)
        {
            ds = new DruidDataSource();
        }
        return ds;
    }

//拿链接
    public Connection getConnection()
    {
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//测试能否拿到链接
    public static void main(String[] args) {
        DruidDataSource duridDataSource = DruidDataSource.getDataSource();
        Connection connection = duridDataSource.getConnection();
        System.out.println(connection);
    }

}
