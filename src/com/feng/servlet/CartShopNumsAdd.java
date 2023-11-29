package com.feng.servlet;

import com.feng.dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartShopNumsAdd extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("count");
        String pid = request.getParameter("pid");

        CartDao cartDao=new CartDao();
        cartDao.updateCartNums_addsub(Integer.parseInt(count),Integer.parseInt(pid));
    }
}
