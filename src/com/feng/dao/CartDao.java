package com.feng.dao;

import com.feng.entity.Cart;
import com.feng.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {
    //查询用户u_id的购物车中是否存在商品p_id
    public int selectByuidpid(String uid,int pid){
        int count=0;
        JdbcUtil util=new JdbcUtil();
        String sql="select cart_nums from cart where cart_u_id=? and cart_p_id=?";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,uid);
            ps.setInt(2,pid);
            rs=ps.executeQuery();
            if (rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return count;
    }

    //更新购物车中的信息
    public void updateBynums(int temp,int count,int pid,String uid){
        JdbcUtil util=new JdbcUtil();
        String sql = "update cart set cart_nums=?,cart_valid=? where cart_u_id=? and cart_p_id=?";
        PreparedStatement ps=util.getPs(sql);
        try {
            ps.setInt(1,temp+count);
            ps.setInt(2,1);
            ps.setString(3,uid);
            ps.setInt(4,pid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps);
        }
    }

    //插入购物车信息
    public int insert(Cart cart){
        int count=0;
        JdbcUtil util=new JdbcUtil();
        String sql = "insert into cart values(null, ?, ?, ?, ?, ?, ?, ?, 1)";
        PreparedStatement ps=util.getPs(sql);
        try {
            ps.setString(1,cart.getCart_p_filename());
            ps.setString(2,cart.getCart_p_name());
            ps.setInt(3,cart.getCart_p_price());
            ps.setInt(4,cart.getCart_nums());
            ps.setInt(5,cart.getCart_p_stock());
            ps.setInt(6,cart.getCart_p_id());
            ps.setString(7,cart.getCart_u_id());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps);
        }
        return count;
    }

    //查找用户所有购物车信息
    public ArrayList<Cart> selectAll(String uid){
        ArrayList<Cart> list=new ArrayList<>();
        JdbcUtil util=new JdbcUtil();
        String sql = "select * from cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,uid);
            rs=ps.executeQuery();
            while(rs.next()){
                Cart cart=new Cart(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_nums"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );
                list.add(cart);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return list;
    }

    //删除购物车信息
    public void deleteBycartid(int id){
        JdbcUtil util=new JdbcUtil();
        String sql="delete from cart where cart_id=?";
        PreparedStatement ps=util.getPs(sql);
        try {
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps);
        }
    }

    //购物车商品数量减一加一
    public void updateCartNums_addsub(int count,int pid){
        JdbcUtil util=new JdbcUtil();
        String sql = "update cart set cart_nums=? where cart_id=? ";
        PreparedStatement ps=util.getPs(sql);
        try {
            ps.setInt(1,count);
            ps.setInt(2,pid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //购物车结算
    public Cart getCartShop(String id){
        Cart cart=null;
        JdbcUtil util=new JdbcUtil();

        String sql = "select * from cart where cart_id=? and cart_valid=1";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                cart=new Cart(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_nums"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return cart;
    }

    //结算支付后修改购物车信息
    public void updateBycartid(int id){
        JdbcUtil util=new JdbcUtil();
        String sql = "update cart set cart_valid=? where cart_id=? ";
        PreparedStatement ps=util.getPs(sql);
        try {
            ps.setInt(1,0);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps);
        }
    }
}
