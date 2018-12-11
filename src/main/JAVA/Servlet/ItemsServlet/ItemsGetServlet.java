package Servlet.ItemsServlet;

import DAO.ItemsDAO;
import DAOImpl.ItemsDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="ItemsGetServlet",urlPatterns = "")
public class ItemsGetServlet extends HttpServlet {

    ItemsDAO itemsDAO;

    public void init() throws ServletException {
        itemsDAO=new ItemsDAOImpl();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String catagory=req.getParameter("catagory");

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}
