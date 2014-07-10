package com.richardxu.examples.jdbc;

/*
 * File: Conn.java
 * Author: xufeng  xufeng@richardxu.com
 * Purpose: connect to MySQL
 */

import java.sql.*;

public class Conn{
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://127.0.0.1/foo?characterEncoding=utf-8";
    static String user = "root";
    static String password = "123456";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);   // DriverManager: 完成驱动程序的装载和建立新的数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void free(ResultSet rs, Connection conn, Statement stmt) {
        try {
            if (rs!= null) {
                rs.close();    // 关闭结果集
            }
        } catch (SQLException e) {
            System.out.println( "关闭 ResultSet 失败!" );
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();  // 关闭连接
                }
            } catch (SQLException e) {
                System.out.println( "关闭 Connection 失败!" );
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();  // 关闭 Statement 对象
                    }
                } catch (SQLException e) {
                    System.out.println( "关闭 Statement 失败!" );
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {

    }
}
