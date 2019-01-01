package DAOImpl;

import DAO.IVideoDAO;
import Mo.Video;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VideoDAOImplTest {
    IVideoDAO videoDAO=new VideoDAOImpl();
    @Test
    public void getindexvideo() {

        List<Video> videoList=new ArrayList<Video>();

        for(Video video:videoList){
            System.out.println(video);
        }
    }

    @Test
    public void getvideo() {

        Video video=videoDAO.getvideo(12);
        System.out.println(video);
    }

    @Test
    public void getnewvideo() {

        List<Video> videoList=new ArrayList<Video>();
        videoList=videoDAO.getnewvideo();
        for(Video video:videoList){
            System.out.println(video);
        }
    }

    @Test
    public void gettimes() {
        int id=videoDAO.gettimes(12);
        System.out.println(id);
    }
}