package DAOImpl;

import DAO.ItemsDAO;
import Mo.Items;
import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAOImpl implements ItemsDAO {
    public List<Items> getItems(String catagroy) {
        String sql="select answer,it_content,A,B,C,D,analyse,knowledge from items where catagroy=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Items> itemsList=new ArrayList<Items>();
        try {
            conn= JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,catagroy);
            rs=ps.executeQuery();
            while(rs.next()){
                Items items=new Items();
                items.setAnswer(rs.getString(1));
                items.setA(rs.getNString(2));
                items.setB(rs.getNString(3));
                items.setC(rs.getNString(4));
                items.setD(rs.getNString(5));
                items.setAnalyse(rs.getString(6));
                items.setKnowledge(rs.getString(7));
                itemsList.add(items);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return itemsList;
    }
}
