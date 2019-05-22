package com.neuedu.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {

//读取resouce内文件

    private static DruidDataSource ds = null;

    private static Properties prop = new Properties();
    private DruidDataSource()
    {

    }

//保证连接池单例
    public static DruidDataSource getDataSource()
    {
        if (null == ds)
        {
            ds = new DruidDataSource();
        }
        return ds;
    }


//拿到链接
    public Connection getConnection()
    {
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DruidDataSource dataSource = DruidDataSource.getDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
