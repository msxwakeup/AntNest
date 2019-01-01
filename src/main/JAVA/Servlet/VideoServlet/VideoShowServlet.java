package Servlet.VideoServlet;

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

@WebServlet(name = "VideoShowServlet",urlPatterns = "/showvideo")
public class VideoShowServlet extends HttpServlet {

    IVideoDAO videoDAO;
    public void init(ServletConfig config) throws ServletException {
        videoDAO=new VideoDAOImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String id=req.getParameter("vid");
         Integer vid=Integer.parseInt(id);
         Video video=videoDAO.getvideo(vid);

         req.setAttribute("video",video);
         req.getRequestDispatcher("/jsp/videoshow.jsp").forward(req,resp);
    }
}
