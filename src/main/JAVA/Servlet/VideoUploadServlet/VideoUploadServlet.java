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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "VideoUploadServlet",urlPatterns = "/uploadvideo.do")
public class VideoUploadServlet extends HttpServlet {
    IVideoDAO videoDAO;

    public void init() throws ServletException {
        videoDAO=new VideoDAOImpl();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        UploadUtil uploadUtil=new UploadUtil(this,req);

        String videoname=uploadUtil.processFormField("videoname");
        String knowledge=uploadUtil.processFormField("knowledge");
        String newname="";
        try {

            newname=uploadUtil.processUploadedFile("video","videos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Video video=new Video();
        SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(time.format(new Date()));// new Date()为获取当前系统时间
        video.setVideoName(videoname);
        video.setUpTime(time.format(new Date()));
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
