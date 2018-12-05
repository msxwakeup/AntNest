package Servlet.LogRegServlet;

import DAO.IMemberDAO;
import DAOImpl.MemberDAOImpl;
import Mo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegServlet",urlPatterns = "/reg.do")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String repwd = request.getParameter("repwd");
        String mno = request.getParameter("mno");

        //判断注册名和密码，电话号码是否为空
        if (name != null && name.trim().equals("") || pwd != null && pwd.trim().equals("") || repwd != null && repwd.trim().equals("") || mno != null && mno.trim().equals("")) {
            request.setAttribute("regname", "会员名、密码、电话号码不能为空");
            request.getRequestDispatcher("regerror.jsp").forward(request, response);
            return;
        }
        //两次密码是否匹配
        if (!repwd.equals(pwd)) {
            request.setAttribute("rename", "两次密码不一致");
            request.getRequestDispatcher("regerror.jsp").forward(request, response);
            return;
        }
        //判断号码是否规范

        IMemberDAO iMemberDAO = new MemberDAOImpl();
        Member member = new Member();

        int imno = Integer.parseInt(mno);
        member.setmName("name");
        member.setmPwd("pwd");
        member.setMemNO(imno);
        boolean flag = false;
        //查找会员号码是否已存在被注册过
        Member member1 = null;
        try {
            member1 = iMemberDAO.getMember(imno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (member1 != null) {
            request.setAttribute("regname", "该号码已被注册过");
            request.getRequestDispatcher("regerror.jsp").forward(request, response);
            return;
        }
        //添加用户
        try {
            flag = iMemberDAO.addMember(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            request.setAttribute("regname",name);
            request.getRequestDispatcher("/regok.jsp").forward(request,response);
        }
        else{
            request.setAttribute("regname",name);
            request.getRequestDispatcher("/regerror.jsp").forward(request,response);

        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
