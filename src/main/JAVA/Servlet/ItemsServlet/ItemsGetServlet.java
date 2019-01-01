package Servlet.ItemsServlet;

import DAO.IFinishitemDAO;
import DAO.ItemsDAO;
import DAOImpl.FinishitemDAOImpl;
import DAOImpl.ItemsDAOImpl;
import Mo.Items;
import Mo.Member;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="ItemsGetServlet",urlPatterns = "/selectitems.do")
public class ItemsGetServlet extends HttpServlet {

    ItemsDAO itemsDAO;
    IFinishitemDAO finishitemDAO;

    public void init() throws ServletException {
        itemsDAO=new ItemsDAOImpl();
        finishitemDAO=new FinishitemDAOImpl();

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        Integer finishtime= (Integer) session.getAttribute("finishtime");
        if(finishtime==null){
            finishtime=0;
        }
        int memid=2;
        String catagory=req.getParameter("catagory");
        String topic=req.getParameter("topic");
        Integer number=(Integer) session.getAttribute("num");  //设立的session，查看上一题或者下一题所用
        if(number==null){
            number=0;
        }

        int itemnum;  //传过来的+1或者-1
        if(topic==null){
            itemnum=0;
            session.removeAttribute("num");
        }else{
            itemnum=Integer.parseInt(topic); //+1或者—1
        }

        int size=number+itemnum;
        if(size<0)
        { size=0; }

        Items item = itemsDAO.getitem(catagory, size);
        String answer="-1";

        if(itemnum==-1){
            int num=1;
                  num=size+1;
             answer=finishitemDAO.getanwser(memid,num,finishtime,catagory);
            if(answer==null){
                answer="-1";
            }else{


            }
        }
        if(itemnum==1){
            int num=size+1;
             answer=finishitemDAO.getanwser(memid,num,finishtime,catagory);

            if(answer==null){
                answer="-1";
            }else{


            }
        }
        req.setAttribute("theanswer",answer);
        session.setAttribute("num", size);
        req.setAttribute("item", item);
        req.getRequestDispatcher("/jsp/items/itemsindex.jsp").forward(req, resp);


    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
