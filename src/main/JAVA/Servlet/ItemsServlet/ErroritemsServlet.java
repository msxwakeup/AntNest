package Servlet.ItemsServlet;

import DAO.IErroritemDAO;
import DAOImpl.ErroritemDAOImpl;
import Mo.ErrorItem;
import Mo.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ErroritemsServlet",urlPatterns = "/geterroritem")
public class ErroritemsServlet extends HttpServlet {
    IErroritemDAO erroritemDAO;


    public void init(ServletConfig config) throws ServletException {
       erroritemDAO=new ErroritemDAOImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        Member member=(Member) session.getAttribute("");

        String anwser=req.getParameter("anwser");
        String id=req.getParameter("itid");
        Integer itid=Integer.parseInt(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());
        int errortimes=erroritemDAO.getItemtimes(3,itid);

        if(errortimes==0){
            ErrorItem errorItem=new ErrorItem();
            errorItem.setYanswer(anwser);
            errorItem.setMemId(3);
            errorItem.setItId(itid);
            errorItem.setTimes(1);
            errorItem.setTime(time);
            boolean flag=erroritemDAO.updateErroritems(errorItem);

        }else{
            ErrorItem errorItem=new ErrorItem();
            errorItem.setYanswer(anwser);
            errorItem.setMemId(3);
            errorItem.setItId(itid);
            errorItem.setTime(time);
            errorItem.setTimes(errortimes+1);
            erroritemDAO.updaterrortimes(errorItem);


        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }
}
