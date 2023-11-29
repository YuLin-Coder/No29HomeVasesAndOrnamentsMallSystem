package com.feng.dao;

import com.feng.entity.Product;
import com.feng.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProDao {
    public Product selectById(String pid){
        int id=Integer.parseInt(pid);
        JdbcUtil util=new JdbcUtil();
        String sql="select * from product where PRODUCT_ID=?";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        Product pro=new Product();
        try {
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                pro.setPRODUCT_ID(rs.getInt(1));
                pro.setPRODUCT_NAME(rs.getString(2));
                pro.setPRODUCT_DESCRIPTION(rs.getString(3));
                pro.setPRODUCT_PRICE(rs.getInt(4));
                pro.setPRODUCT_STOCK(rs.getInt(5));
                pro.setPRODUCT_FILENAME(rs.getString(6));
                //Product pro=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return pro;
    }
}
