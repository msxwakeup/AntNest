package DAOImpl;

import DAO.IErroritemDAO;
import Mo.ErrorItem;
import Mo.Finishitem;
import Utils.JDBCUtil;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErroritemDAOImpl implements IErroritemDAO {
    public boolean updateErroritems(ErrorItem erroritem) {
        boolean flag=false;
        String sql="INSERT INTO error(mem_id,it_id,time,Yanswer,times) VALUES(?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,erroritem.getMemId());
            ps.setInt(2,erroritem.getItId());
            ps.setString(3,erroritem.getTime());
            ps.setString(4,erroritem.getYanswer());
            ps.setInt(5,erroritem.getTimes());
            int intflag=ps.executeUpdate();
            if(intflag==1)
            { flag=true;
                return  flag;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return flag;
    }

    public ErrorItem geterroritems(int mid, int itid) {

        String sql="select * from error where mem_id=? and it_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,mid);
            ps.setInt(2,itid);
            rs=ps.executeQuery();
            if(rs.next()){
                ErrorItem errorItem=new ErrorItem();
                errorItem.seteId(rs.getInt(1));
                errorItem.setMemId(rs.getInt(2));
                errorItem.setItId(rs.getInt(3));
                errorItem.setTime(rs.getString(4));
                errorItem.setYanswer(rs.getString(5));
                errorItem.setTimes(rs.getInt(6));
                return errorItem;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }


        return null;
    }

    public int getItemtimes(int mid, int itid) {
        String sql="select times from error where mem_id=? and it_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,mid);
            ps.setInt(2,itid);
            rs=ps.executeQuery();
            if(rs.next()){
                int times=rs.getInt(1);
                return times;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }



        return 0;
    }

    public boolean updaterrortimes(ErrorItem erroritem) {
         String sql="UPDATE  error set times=?,Yanswer=?,time=? where mem_id=? and it_id=?";
         Connection conn=null;
         PreparedStatement ps=null;
         ResultSet rs=null;
         boolean flag=false;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,erroritem.getTimes());
            ps.setString(2,erroritem.getYanswer());
            ps.setString(3,erroritem.getTime());
            ps.setInt(4,erroritem.getMemId());
            ps.setInt(5,erroritem.getItId());
            int intflag=ps.executeUpdate();
            if(intflag==1){
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

        return flag;
    }
}
