package com.feng.servlet;

import com.feng.dao.CartDao;
import com.feng.entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CartPay extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String eids = request.getParameter("eids");
        String ids[] = eids.split(",");

        for(int i=0; i<ids.length; i++) {
            CartDao cartDao=new CartDao();
            cartDao.updateBycartid(Integer.parseInt(ids[i]));
        }
        response.sendRedirect("ok.jsp");
    }
}
