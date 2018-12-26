package DAOImpl;

import DAO.IFinishitemDAO;
import Mo.Finishitem;
import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FinishitemDAOImpl implements IFinishitemDAO {
    public boolean yetfinitem(Finishitem finishitem) {
        boolean flag=false;
        String sql="INSERT INTO finishitem(mem_id,it_id,it_catagroy,fi_id_num,finishtimes,Yanswer) VALUES(?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,finishitem.getMemId());
            ps.setInt(2,finishitem.getItId());
            ps.setString(3,finishitem.getItcatagroy());
            ps.setInt(4,finishitem.getFiIdnum());
            ps.setInt(5,finishitem.getFinishtimes());
            ps.setString(6,finishitem.getYanswer());

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

    public String getanwser(int memid, int fiidnum, int finishtimes, String catagroy) {
        String sql="SELECT Yanswer from finishitem where mem_id=? and it_catagroy=? and fi_id_num=? and finishtimes=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,memid);
            ps.setString(2,catagroy);
            ps.setInt(3,fiidnum);
            ps.setInt(4,finishtimes);
            rs=ps.executeQuery();
            if(rs.next()){
                String answer=rs.getString(1);
                return answer;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

        return null;
    }

    public int getfinishtimes(int memid, String catagroy) {
        String sql="SELECT MAX(finishtimes)  from finishitem  where  mem_id=? and it_catagroy=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,memid);
            ps.setString(2,catagroy);
            rs=ps.executeQuery();
            if(rs.next()){
                int finishtimes=rs.getInt(1);
                return finishtimes;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return 0;
    }

    public int getnowfiidnum(int memid, int finishtime, String catagroy) {
        String sql="SELECT MAX(fi_id_num)  from finishitem  where  mem_id=? and it_catagroy=? and finishtimes=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,memid);
            ps.setString(2,catagroy);
            ps.setInt(3,finishtime);
            rs=ps.executeQuery();
            if(rs.next()){
                int nowfinish=rs.getInt(1);
                return nowfinish;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return 0;
    }



}
