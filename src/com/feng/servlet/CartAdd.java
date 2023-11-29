package com.feng.servlet;

import com.feng.dao.CartDao;
import com.feng.dao.ProDao;
import com.feng.entity.Cart;
import com.feng.entity.Product;
import com.feng.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String pid=request.getParameter("id");
        String count=request.getParameter("count");
        String flag=request.getParameter("flag");
        int p_id=Integer.parseInt(pid);

        HttpSession session=request.getSession(false);
        if (session!=null){
            //获取用户id
            User user=(User)session.getAttribute("user");
            String u_id=user.getId();
            //获取商品信息
            ProDao dao=new ProDao();
            Product pro=dao.selectById(pid);
            //添加商品到购物车，有两规则
            //若用户u_id的购物车中已经存在商品p_id,则更新商品数量加上cout
            //若用户u_id的购物车中没有商品p_id,则插入数据到购物车
            CartDao cartDao=new CartDao();
            int temp=cartDao.selectByuidpid(u_id,p_id);
            if (temp>0){
//                更新购物车
                cartDao.updateBynums(temp,Integer.parseInt(count),p_id,u_id);
                //更新商品库存

            }else{
                if (Integer.parseInt(count)<=pro.getPRODUCT_STOCK()) {
                    Cart cart = new Cart(0, pro.getPRODUCT_FILENAME(), pro.getPRODUCT_NAME(), pro.getPRODUCT_PRICE(), Integer.parseInt(count), pro.getPRODUCT_STOCK(), pro.getPRODUCT_ID(), u_id, 1);
                    //插入购物车
                    cartDao.insert(cart);
                    //更新商品库存

                }else{
                    PrintWriter out = response.getWriter();
                    out.write("<script>");
                    out.write("alert('库存不足，请重新选择');");
                    out.write("location.href='productshow?id=6';");
                    out.write("</script>");
                    out.close();
                    return;
                }
            }
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('请先登录后，再购买');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
            return;
        }
        if(flag.equals("z")) {
            response.sendRedirect("showcart");
        }else{
            response.sendRedirect("productshow?id="+p_id);
        }
    }
}
