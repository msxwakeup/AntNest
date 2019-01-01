package Servlet.ItemsServlet;

import DAO.IFinishitemDAO;
import DAOImpl.FinishitemDAOImpl;
import Mo.Finishitem;
import Mo.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FinishitemServlet",urlPatterns = "/finishitems")
public class FinishitemServlet extends HttpServlet {

    IFinishitemDAO finishitemDAO;


    public void init(ServletConfig config) throws ServletException {
        finishitemDAO=new FinishitemDAOImpl();

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        Member member=(Member) session.getAttribute("");

        Integer fintime= (Integer) session.getAttribute("finishtime");

        int memid=2;
        String anwser=req.getParameter("anwser");
        String id=req.getParameter("itid");
        String catagroy=req.getParameter("catagroy");
        Integer itid=Integer.parseInt(id);
        int finishtime=finishitemDAO.getfinishtimes(memid,catagroy);

        if(fintime==null){
            finishtime=finishtime+1;
            Finishitem finishitem=new Finishitem();
            finishitem.setMemId(memid);
            finishitem.setItId(itid);
            finishitem.setFiIdnum(1);
            finishitem.setItcatagroy(catagroy);
            finishitem.setFinishtimes(finishtime);
            finishitem.setYanswer(anwser);
            session.setAttribute("finishtime",finishtime);
            finishitemDAO.yetfinitem(finishitem);
        }
        if(fintime!=null) {
            int num=finishitemDAO.getnowfiidnum(memid,finishtime,catagroy);
            String oldanswer=finishitemDAO.getanwserUseritid(memid,itid,finishtime);

            Finishitem finishitem=new Finishitem();
            finishitem.setMemId(memid);
            finishitem.setItId(itid);
            finishitem.setItcatagroy(catagroy);
            finishitem.setFinishtimes(finishtime);
            finishitem.setYanswer(anwser);

            if(oldanswer==null){
                int fiidnum=num+1;
                finishitem.setFiIdnum(fiidnum);
                boolean flag=false;
                flag=finishitemDAO.yetfinitem(finishitem);
            }else if(oldanswer!=null){
                finishitem.setFiIdnum(num);
                finishitemDAO.updatefinishitem(finishitem);
            }





        }





//        out.write("success");
//        out.flush();
//        out.close();


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
