package Servlet;

import DAO.IAdminDAO;
import DAOImpl.AdminDAOImpl;
import Mo.Adminer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/login.do",name = "LoginServlet" )
public class LoginServlet extends HttpServlet {
    IAdminDAO adminDAO;
    public void init() throws ServletException {
        adminDAO=new AdminDAOImpl();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String aname=req.getParameter("aname");
        String apwd=req.getParameter("apwd");
        boolean flag=false;
        flag=adminDAO.CheckAdmin(aname,apwd);
        System.out.println(flag);
        if(flag){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
//            req.setAttribute("error","密码错误或该用户不存在");
//            req.getRequestDispatcher("/JSPs/log reg/login.jsp").forward(req,resp);
//            return;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
