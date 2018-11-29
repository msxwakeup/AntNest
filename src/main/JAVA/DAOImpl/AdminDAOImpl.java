package DAOImpl;

import DAO.IAdminDAO;
import Mo.Adminer;
import Utils.JDBCUtil;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements IAdminDAO {

    public Adminer getAdmin(String admName, String admPwd) {

    String sql = "select name,pwd from adminer where NAME=? and pwd=?";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        Adminer adminer = new Adminer();
        try {
        conn = JDBCUtil.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1,admName);
        ps.setString(2,admPwd);
        rs = ps.executeQuery();
        if (rs.next()) {
            adminer.setaName(rs.getString(1));
            adminer.setaPwd(rs.getString(2));
            return adminer;
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(conn, ps, rs);
    }
        return adminer;
}

    public boolean CheckAdmin(String name, String pwd) {

        boolean flag=false;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select name,pwd from adminer where name=?";

        try{
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                String apwd=rs.getString(2);
                if(apwd.equals(pwd))
                    flag=true;
            }

        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return flag;
    }

}
