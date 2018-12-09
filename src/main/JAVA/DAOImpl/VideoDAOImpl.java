package DAOImpl;

import DAO.IVideoDAO;
import Mo.Video;
import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VideoDAOImpl implements IVideoDAO {
    public boolean uploadVideo(Video video) {
        boolean flag=false;
        String sql="INSERT into video(video_name,v_link,knowledge) VALUES(?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,video.getVideoName());
            ps.setString(2,video.getvLink());
            ps.setString(3,video.getKnowledge());
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
}
