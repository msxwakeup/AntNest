package Servlet.ItemsServlet;

import DAO.ItemsDAO;
import DAOImpl.ItemsDAOImpl;
import Mo.Items;
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

    int ja=0;
    int js=0;
    public void init() throws ServletException {
        itemsDAO=new ItemsDAOImpl();

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String catagory=req.getParameter("catagory");
        String topic=req.getParameter("topic");
        int itemnum;
        if(topic==null){
            itemnum=0;
            session.removeAttribute("num");
        }else{
            itemnum=Integer.parseInt(topic);
        }

        Integer number=(Integer) session.getAttribute("num");

        int num=0;
        if(number==null){
            number=0;
        }else {
            num=number;
        }
        int size=num+itemnum;
        if(size<0)
        { size=0; }
        Items item = itemsDAO.getitem(catagory, size);

        session.setAttribute("num", size);
        req.setAttribute("item", item);
        req.getRequestDispatcher("/jsp/items/itemsindex.jsp").forward(req, resp);


    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
