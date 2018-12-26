package DAOImpl;

import DAO.IMaterialDAO;
import Mo.Material;
import Utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAOImpl implements IMaterialDAO {

    @Override
    public List<Material> getMaterial(String names) throws SQLException {
        List<Material> materialList=new ArrayList<Material>();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select  m_id, m_name,knowledge,link FROM material where m_name like ? ";
           // String sql="select name12,knowledge,link FROM material where name12 like "+names+"";

            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);

             ps.setString(1,"%"+names+"%");
            rs=ps.executeQuery();

            while (rs.next()){

                Material material=new Material();
                material.setM_id(rs.getInt(1));
                material.setName(rs.getString(2));
                material.setKnowledge(rs.getString(3));
                material.setLink(rs.getString(4));
                materialList.add(material);


            }
            return materialList;

        }finally {
            JDBCUtil.close(conn, ps, rs);
        }

    }

    @Override
    public Material getMaterials(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select link FROM material where m_id=?";
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            Material material = null;
            while (rs.next()) {
                material = new Material();
                material.setLink(rs.getString(1));
            }
            return material;

        } finally {
            JDBCUtil.close(conn, ps, rs);
        }

    }

    @Override
    public boolean uploadMaterial(Material material) throws SQLException {
        boolean flag=false;

        Connection conn=null;
        PreparedStatement ps=null;
        try {
            String sql="INSERT into material(name,link,knowledge) VALUES(?,?,?)";
            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,material.getName());
            ps.setString(2,material.getLink());
            ps.setString(3,material.getKnowledge());
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

    @Override
    public List<Material> getSeries(String knowledge,int start,int size) throws SQLException {
        List<Material> materialList=new ArrayList<Material>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            String sql="select m_id, m_name,knowledge,link\n" +
                    " FROM material where knowledge like ?  limit ?,?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"%"+knowledge+"%");
            ps.setInt(2,start);
            ps.setInt(3,size);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Material material=new Material();
                material.setM_id(rs.getInt(1));
                material.setName(rs.getString(2));
                material.setKnowledge(rs.getString(3));
                material.setLink(rs.getString(4));
                materialList.add(material);
            }
            return materialList;

        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

    }

    @Override
    public List<Material> getshow(String name,int start, int size) throws SQLException {
        List<Material> materialList=new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=JDBCUtil.getConn();
            String sql="select m_id, m_name,knowledge,link\n" +
                    " FROM material where m_name like ?  limit ?,?";

            ps=con.prepareStatement(sql);
            ps.setString(1,"%"+name+"%");
            ps.setInt(2,start);
            ps.setInt(3,size);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Material material=new Material();
                material.setM_id(rs.getInt(1));
                material.setName(rs.getString(2));
                material.setKnowledge(rs.getString(3));
                material.setLink(rs.getString(4));
                materialList.add(material);
            }
            return materialList;

        }finally {
            JDBCUtil.close(con,ps,rs);
        }

    }
}


