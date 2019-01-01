package Servlet;

import DAO.IVideoDAO;
import DAOImpl.VideoDAOImpl;
import Mo.Video;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index.do")
public class indexServlet extends HttpServlet {

     IVideoDAO videoDAO;
    public void init(ServletConfig config) throws ServletException {
     videoDAO=new VideoDAOImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Video> videoList=new ArrayList<Video>();
        videoList=videoDAO.getIndexvideo();
        req.setAttribute("videolist",videoList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doGet(req,resp);
    }
}
