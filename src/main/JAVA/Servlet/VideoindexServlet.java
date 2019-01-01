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

@WebServlet(name = "VideoindexServlet",urlPatterns = "/video.do")
public class VideoindexServlet extends HttpServlet {

    IVideoDAO videoDAO;
    public void init(ServletConfig config) throws ServletException {
        videoDAO=new VideoDAOImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link=req.getParameter("name");
        List<Video> videos=new ArrayList<Video>();

        if(link==null){
            videos=videoDAO.getvideos(8);
        }else if("new".equals(link)){
            videos=videoDAO.getnewvideo();
        }else if("hot".equals(link))
        {
            videos=videoDAO.getTimesvideo();
        }
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/video.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
}
