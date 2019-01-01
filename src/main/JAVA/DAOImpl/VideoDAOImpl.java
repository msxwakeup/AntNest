package DAOImpl;

import DAO.IVideoDAO;
import Mo.Items;
import Mo.Video;
import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideoDAOImpl implements IVideoDAO {

    public boolean uploadVideo(Video video) {
        boolean flag=false;
        String sql="INSERT into video(a_id,m_k_id,video_name,up_time,v_link,videoimg,knowledge) VALUES(?,?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,video.getaId());
            ps.setInt(2,video.getMkId());
            ps.setString(3,video.getVideoName());
            ps.setString(4,video.getUpTime());
            ps.setString(5,video.getvLink());
            ps.setString(6,video.getVideoimg());
            ps.setString(7,video.getKnowledge());
            int intflag=ps.executeUpdate();
            if(intflag==1)  flag=true;
            return flag;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,null);
        }
        return flag;
    }

    public List<Video> getnewvideo() {
        String sql="select v_id,video_name,videoimg from video order by v_id desc";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Video> videos=new ArrayList<Video>();
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while(rs.next()){
                Video video=new Video();
                video.setvId(rs.getInt(1));
                video.setVideoName(rs.getString(2));
                video.setVideoimg(rs.getString(3));
                videos.add(video);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return videos;
    }

    public List<Video> getIndexvideo() {
        String sql="select v_id,video_name,videoimg from video order by times DESC LIMIT 0,8";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Video> videos=new ArrayList<Video>();
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Video video=new Video();
                video.setvId(rs.getInt(1));
                video.setVideoName(rs.getString(2));
                video.setVideoimg(rs.getString(3));
                videos.add(video);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return videos;
    }

    public List<Video> getvideos(int size) {
        String sql="select v_id,video_name,videoimg from video  LIMIT 0,?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
       List<Video> videos=new ArrayList<Video>();
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,size);
            rs=ps.executeQuery();
            while(rs.next()){
                Video video=new Video();
                video.setvId(rs.getInt(1));
                video.setVideoName(rs.getString(2));

                video.setVideoimg(rs.getString(3));
                videos.add(video);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return videos;
    }

    public Video getvideo(int id) {
        String sql="select v_id,video_name,videoimg,v_link,knowledge from video  WHERE v_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                Video video=new Video();
                video.setvId(rs.getInt(1));
                video.setVideoName(rs.getString(2));
                video.setVideoimg(rs.getString(3));
                video.setvLink(rs.getString(4));
                video.setKnowledge(rs.getString(5));
                return video;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return null;
    }

    public boolean savevideotimes(int newtimes,int vid) {
        String sql="UPDATE video set times=? WHERE v_id=?";
        boolean flag=false;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,newtimes);
            ps.setInt(2,vid);
            int inflag=ps.executeUpdate();
            if(inflag==1){
                flag=true;
                return flag;
            }



        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return flag;
    }

    public int gettimes(int id) {
        String sql="SELECT times from video where v_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                int nowtimes=rs.getInt(1);
                return nowtimes;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return 0;
    }

    public List<Video> getTimesvideo() {
        String sql="select v_id,video_name,videoimg from video order by times DESC";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Video> videos=new ArrayList<Video>();
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Video video=new Video();
                video.setvId(rs.getInt(1));
                video.setVideoName(rs.getString(2));
                video.setVideoimg(rs.getString(3));
                videos.add(video);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return videos;
    }
}
