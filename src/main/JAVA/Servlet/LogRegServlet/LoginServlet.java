package Servlet.LogRegServlet;

import DAO.IAdminDAO;
import DAO.IMemberDAO;
import DAOImpl.AdminDAOImpl;
import DAOImpl.MemberDAOImpl;
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
    IMemberDAO memberDAO;

    public void init() throws ServletException {
        adminDAO = new AdminDAOImpl();
        memberDAO = new MemberDAOImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String get = req.getParameter("link");
        System.out.println(get);
        if ("member".equals(get)) {
            this.doMember(req, resp);

        }
        if ("adminer".equals(get)) {
            this.doAdmin(req, resp);
        }


    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               doPost(req,resp);
    }

    protected void doAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        boolean flag = false;
        flag = adminDAO.CheckAdmin(name,pwd);
        System.out.println(flag);
        if (flag) {
            System.out.println("管理员登录成功");
        } else {
            System.out.println("管理员登录失败");
//            req.setAttribute("error","密码错误或该用户不存在");
//            req.getRequestDispatcher("/JSPs/log reg/login.jsp").forward(req,resp);
//            return;
        }

    }
    protected void doMember(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mname = req.getParameter("name");
        String mpwd = req.getParameter("pwd");
        System.out.println(mname);
        System.out.println(mpwd);
        boolean flag1 = false;
        flag1 = memberDAO.checkMember(mname, mpwd);
        System.out.println(flag1);
        if (flag1) {
            System.out.println("用户登录成功");
        } else {
            System.out.println("用户登录失败");
//            req.setAttribute("error","密码错误或该用户不存在");
//            req.getRequestDispatcher("/JSPs/log reg/login.jsp").forward(req,resp);
//            return;
        }
    }
}