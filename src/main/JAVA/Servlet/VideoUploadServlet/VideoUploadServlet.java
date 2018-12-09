package Servlet.VideoUploadServlet;

import DAO.IVideoDAO;
import DAOImpl.VideoDAOImpl;
import Mo.Member;
import Mo.Video;
import Utils.UploadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "VideoUploadServlet",urlPatterns = "/uploadvideo.do")
public class VideoUploadServlet extends HttpServlet {
    IVideoDAO videoDAO;

    public void init() throws ServletException {
        videoDAO=new VideoDAOImpl();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String videoname=req.getParameter("videoname");
        String knowledge=req.getParameter("knowledge");
        UploadUtil uploadUtil=new UploadUtil(this,req);
        String newname="";
        System.out.println("1111:"+this.getServletConfig().getServletContext().getContextPath());
        try {
            newname=uploadUtil.processUploadedFile("video","videos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(newname);
        Video video=new Video();
        video.setVideoName(videoname);
        video.setvLink("videos/"+newname);
        video.setKnowledge(knowledge);
        boolean flag=false;
        flag=videoDAO.uploadVideo(video);
        if(flag)
            System.out.println("成功");
        else
            System.out.println("失败");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
