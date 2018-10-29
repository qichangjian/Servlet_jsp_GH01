package com.qcj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *   servlet的访问路径：http://loaclhost:8080/Servlet_jsp_GH01/user
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到的get请求");

        //修改post请求的乱码问题
        req.setCharacterEncoding("UTF-8");//可以，不是乱码了
        //修改响应传输的编码
        resp.setCharacterEncoding("UTF-8");//不行，还是乱码  这是传输的编码方式
        //设置响应回去的数据类型   html 展示是utf-8展示
        resp.setContentType("text/html;charset=utf-8");


        //获取请求参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        //获取其他信息
        String method = req.getMethod();//请求方式
        String remoteAddr = req.getRemoteAddr();//客户端请求地址IP
        int remotePort = req.getRemotePort();//客户端端口
        System.out.println(username + ":" + pwd);

        //向request域中存值
        req.setAttribute("Username",username);
        //从request域中取值
        System.out.println("username:::" + req.getAttribute("Username"));
        //移除值
        //req.removeAttribute("Username");


        //response 响应
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<p>success</p>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到的post请求");
        doGet(req,resp);
    }
}
