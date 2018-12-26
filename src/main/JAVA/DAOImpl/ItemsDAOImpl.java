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
        String sql="select it_id,answer,it_content,A,B,C,D,analyse,knowledge,catagroy from items where catagroy=?";
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
                items.setItId(rs.getInt(1));
                items.setAnswer(rs.getString(2));
                items.setItContent(rs.getString(3));
                items.setaKey(rs.getNString(4));
                items.setbKey(rs.getNString(5));
                items.setcKey(rs.getNString(6));
                items.setdKey(rs.getNString(7));
                items.setAnalyse(rs.getString(8));
                items.setKnowledge(rs.getString(9));
                items.setCatagroy(rs.getString(10));
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

    public Items getitem(String catagroy, int num) {
        String sql="SELECT it_id,answer,it_content,A,B,C,D,analyse,knowledge,catagroy from items where catagroy=? LIMIT ?,1";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,catagroy);
            ps.setInt(2,num);
            rs=ps.executeQuery();
            if(rs.next()){
                Items item=new Items();
                item.setItId(rs.getInt(1));
                item.setAnswer(rs.getString(2));
                item.setItContent(rs.getString(3));
                item.setaKey(rs.getNString(4));
                item.setbKey(rs.getNString(5));
                item.setcKey(rs.getNString(6));
                item.setdKey(rs.getNString(7));
                item.setAnalyse(rs.getString(8));
                item.setKnowledge(rs.getString(9));
                item.setCatagroy(rs.getString(10));
                return item;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        return null;
    }
}
