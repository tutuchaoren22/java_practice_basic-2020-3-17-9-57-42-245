package com.thoughtworks.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    public static Connection getConnection() throws Exception {
        //1:读取配置文件中的基本信息
        /*InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("src/jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");*/
        String url = "jdbc:mysql://localhost:3306/student_sys?useUnicode=true&characterEncoding=utf-8&serverTimezone=Hongkong";
        String user = "root";
        String password = "123456";
        //2:加载Driver驱动
//        Class.forName(driverClass);
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3:获取连接
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeResource(Connection conn, Statement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement preparedStatement, ResultSet resultSet) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
