package DAOImpl;

import DAO.IMemberDAO;
import Mo.Member;
import Utils.JDBCUtil;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.*;

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
            ps.setString(1,member.getMemNO());
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


    public Member getMember(String  memNo) {
        String sql="select * from member where mem_no=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Member member=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,memNo);
            rs=ps.executeQuery();
            if(rs.next()){
                member=new Member();
                member.setMemId(rs.getInt(1));
                member.setMemNO(rs.getString(2));
                member.setmName(rs.getString(3));
                member.setmGender(rs.getString(4));
                member.setmAge(rs.getInt(5));
                member.setmPwd(rs.getString(6));
                member.setmPhoto(rs.getString(7));
                member.setmIntegral(rs.getInt(8));

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return  member; //如果等于null；不存在用户

    }

    //修改用户的昵称，年龄，性别
    public boolean updateMemberInformation(String mName,Integer mAge,String mGender,String memNo) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag=false;
        String sql = "UPDATE member set name=?,age=?,gender=? where mem_no=?";
        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, mName);
            ps.setInt(2,mAge);
            ps.setString(3, mGender);
            ps.setString(4, memNo);

            int intflag=ps.executeUpdate();
            if(intflag==1)  flag=true;

            return flag;
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }

    //更新头像
    public boolean updateMemberHeadImg(Member member) throws SQLException{
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();
            String sql = "update member\n" +
                    "set photo=?\n" +
                    "where mem_no=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,member.getmPhoto());
            ps.setString(2,member.getMemNO());
            int intflag = ps.executeUpdate();
            if (intflag == 1)
                flag = true;
            return  flag;
        } finally {
            JDBCUtil.close(conn,ps,null);
        }
    }
}
