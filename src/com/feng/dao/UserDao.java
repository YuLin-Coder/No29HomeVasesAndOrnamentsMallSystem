package com.feng.dao;

import com.feng.entity.User;
import com.feng.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对用户的数据库操作
 */
public class UserDao {

    //判断用户名id是否存在
    public int selectByuserId(String userid){
        JdbcUtil util=new JdbcUtil();

        int count=0;
        String sql="select id from user where id=?";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,userid);
            rs=ps.executeQuery();
            if (rs.next()){
                count+=1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return count;
    }

    //用户登录查询
    public int selectByIdPwd(String userId,String pwd){
        int count=0;
        JdbcUtil util=new JdbcUtil();

        String sql="select * from user where id=? and password=?";
        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,userId);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
            if (rs.next()){
                count+=1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return count;
    }

    //插入数据，即注册用户
    public int insert(User u){
        int count=0;

        JdbcUtil util=new JdbcUtil();
        String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,u.getId());
            ps.setString(2,u.getName());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getSex());
            ps.setString(5,u.getBirthday());
            ps.setString(6,u.getIdenity_code());
            ps.setString(7,u.getEmail());
            ps.setString(8,u.getMobile());
            ps.setString(9,u.getAddress());
            ps.setInt(10,u.getStatus());
            count=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }
        return count;
    }
    public User selectuser(String userId){
        User user=new User();

        JdbcUtil util=new JdbcUtil();
        String sql = "select * from user where id=?";

        PreparedStatement ps=util.getPs(sql);
        ResultSet rs=null;
        try {
            ps.setString(1,userId);
            rs=ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setBirthday(rs.getString("birthday"));
                user.setIdenity_code(rs.getString("idenity_code"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
                user.setStatus(rs.getInt("status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
            util.close(ps,rs);
        }

        return user;
    }
}
