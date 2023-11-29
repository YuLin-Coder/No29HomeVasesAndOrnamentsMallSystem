package com.feng.servlet;

import com.feng.dao.CartDao;
import com.feng.entity.Cart;
import com.feng.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowCart extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session=request.getSession(false);
        if (session!=null){
            //获取用户id
            User user=(User)session.getAttribute("user");
            String u_id=user.getId();

            //查询数据库
            CartDao cartDao=new CartDao();
            ArrayList<Cart> cartlist=cartDao.selectAll(u_id);
            request.setAttribute("cartlist", cartlist);

            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('请先登录!');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
            return;
        }
    }
}
