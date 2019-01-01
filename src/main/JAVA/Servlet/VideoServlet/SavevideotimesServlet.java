package Servlet.VideoServlet;

import DAO.IVideoDAO;
import DAOImpl.VideoDAOImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SavevideotimesServlet",urlPatterns = "/savevideotimes")
public class SavevideotimesServlet extends HttpServlet {

    IVideoDAO videoDAO;
    public void init(ServletConfig config) throws ServletException {
        videoDAO=new VideoDAOImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String id=req.getParameter("vid");

        Integer vid=Integer.parseInt(id);
        int times=videoDAO.gettimes(vid);
        boolean flag=videoDAO.savevideotimes(times+1,vid);



    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             doPost(req,resp);
    }
}
