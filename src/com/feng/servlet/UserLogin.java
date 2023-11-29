package com.feng.servlet;

import com.feng.dao.UserDao;
import com.feng.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String userId = request.getParameter("userId");
        String pwd = request.getParameter("passWord");

        //查询数据库的用户表
        UserDao dao=new UserDao();
        int count = dao.selectByIdPwd(userId,pwd);

        if (count>0){
            //用session来管理用户会话登录
            HttpSession session=request.getSession();
            //获取用户信息，保存在session中
            User user=dao.selectuser(userId);
            session.setAttribute("user",user);
            session.setAttribute("isLogin","1");

            //重定向
            response.sendRedirect("index_2.jsp");

        }else{
            PrintWriter out = response.getWriter();
            out.write("<script type=\"text/javascript\">");
            out.write("alert('用户登录失败！请重新登录');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }


    }

}
