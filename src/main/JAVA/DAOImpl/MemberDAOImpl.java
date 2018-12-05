package DAOImpl;

import DAO.IMemberDAO;
import Mo.Member;
import Utils.JDBCUtil;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAOImpl implements IMemberDAO {

    //添加用户
    public boolean addMember(Member member) {
        boolean flag=false;
        if(member==null) return flag;

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();
            String sql="insert into member(mem_no,name,pwd) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,member.getMemNO());
            ps.setString(2,member.getmName());
            ps.setString(3,member.getmPwd());
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

    public boolean checkMember(String memNo, String pwd) {
        boolean flag=false;
        String sql="select mem_no,pwd FROM member where mem_no=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,memNo);
            rs=ps.executeQuery();
            if(rs.next()){
                String mpwd=rs.getString(2);
                if(mpwd.equals(pwd))
                    flag=true;
            }

        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

        return flag;
    }

    public boolean resetpwd(String memNo, String pwd) {
        String sql = "UPDATE member set pwd=? where mem_no=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pwd);
            ps.setString(2, memNo);

            int intflag=ps.executeUpdate();
            if(intflag==1)  flag=true;

            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }

        return flag;
    }

    @Override
    public Member getMember(int  memNo) throws Exception {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            String sql="select mem_id,mem_no,name,pwd FROM member where mem_no=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,memNo);
            rs=ps.executeQuery();

            Member member=null;
            if(rs.next()){
                member=new Member();
                member.setMemId(rs.getInt(1));
                member.setMemNO(rs.getInt(2));
                member.setmName(rs.getString(3));
                member.setmPwd(rs.getString(4));
            }
            return member;
        }
        finally {
            JDBCUtil.close(conn, ps, rs);
        }

    }
}
