package com.qcj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "LoginServlet",value = "/login") //value才是映射地址  name是servlet的名字，而value是访问地址 但是要写urlPatterns属性或者value属性
//@WebServlet(urlPatterns = "/login")
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取参数
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        if(username.equals("111")){
            request.setAttribute("success","登录成功");
        }else{
            request.setAttribute("success","登录失败");
        }
        //响应，跳转页面 （转发，重定向）
        request.getRequestDispatcher("show.jsp").forward(request,response);//转发
        //response.sendRedirect("show.jsp");//重定向
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
