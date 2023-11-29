package com.feng.servlet;

import com.feng.dao.ProDao;
import com.feng.dao.UserDao;
import com.feng.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductShow extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String pid=request.getParameter("id");

        //查询数据库获取商品信息
        ProDao dao=new ProDao();
        Product pro=dao.selectById(pid);

        request.setAttribute("pro",pro);
        request.getRequestDispatcher("proDetail.jsp").forward(request, response);
    }
}
