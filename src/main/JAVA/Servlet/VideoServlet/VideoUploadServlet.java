package Servlet.VideoServlet;

import DAO.IVideoDAO;
import DAOImpl.VideoDAOImpl;
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

@WebServlet(name = "VideoServlet",urlPatterns = "/uploadvideo.do")
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
        String newname=null;
        String newimg=null;
        try {

            newname=uploadUtil.processUploadedFile("video","videos");
            newimg=uploadUtil.processUploadedFile("videoimg","videos/videoImgs");

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(newname==null||newimg==null){
            req.setAttribute("error","上传失败，未选择视频!");
            req.getRequestDispatcher("/jsp/videoupload/videoupload.jsp").forward(req,resp);
            return;
        }
        Video video=new Video();
        SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        video.setVideoName(videoname);
        video.setUpTime(time.format(new Date()));
        video.setvLink("videos/"+newname);
        video.setaId(1);
        video.setMkId(1);
        video.setVideoimg("videos/videoImgs/"+newimg);
        video.setKnowledge(knowledge);
        boolean flag=false;
        flag=videoDAO.uploadVideo(video);
        if(flag)
        {
            System.out.println("成功");
        req.setAttribute("uploadcase","上传成功");
        req.getRequestDispatcher("/jsp/videoupload/uploadcase.jsp").forward(req,resp);

        }
        else{
            System.out.println("失败");
            req.setAttribute("uploadcase1","上传失败");
            req.getRequestDispatcher("/jsp/videoupload/uploadcase.jsp").forward(req,resp);

        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
