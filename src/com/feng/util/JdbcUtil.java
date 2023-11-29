package com.feng.util;

import java.sql.*;

/**
 * 封装
 * Jdbc工具类，简化Jdbc编程
 */
public class JdbcUtil {
    final String URL="jdbc:mysql://localhost:3306/no29_shop2?serverTimezone=GMT";
    final String USERNAME="root";
    final String PASSWORD="123456";
    Connection conn=null;
    PreparedStatement ps=null;

    //将jar包中的driver实现类加载到JVM中
    //静态代码块在类加载时执行，并且只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接对象
     * @return 连接对象Conn
     */
    private  Connection getConn(){
        try {
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    /**
     * 获取数据库操作对象
     * @param
     * @return ps
     */
    public  PreparedStatement getPs(String sql){
        try {
            ps=getConn().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    /**
     * 关闭资源
     */
    public  void close(){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(PreparedStatement ps, ResultSet rs){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
