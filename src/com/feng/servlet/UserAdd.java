package com.feng.servlet;

import com.feng.dao.UserDao;
import com.feng.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userName");
        String name = request.getParameter("name");
        String pwd = request.getParameter("passWord");
        String sex = request.getParameter("sex");
        String year = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        //创建用户实体
        User u = new User(username, name, pwd, sex, year, null, email, mobile, address, 1);

        //加入到数据库的用户表中
        UserDao dao=new UserDao();
        int count = dao.insert(u);

        //成功或失败重定向到哪里
        if(count >0 ) {
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\">");
            out.print("alert('用户注册成功！请登录。');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script type=\"text/javascript\">");
            out.write("alert('用户注册失败！请重新注册。');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
