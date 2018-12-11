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
            String sql="select m_name,knowledge,link FROM material where m_name like ? ";
           // String sql="select name12,knowledge,link FROM material where name12 like "+names+"";

            conn=JDBCUtil.getConn();
            ps=conn.prepareStatement(sql);
            System.out.println(sql);
             ps.setString(1,"%"+names+"%");
            rs=ps.executeQuery();

            while (rs.next()){

                Material material=new Material();
                material.setName(rs.getString(1));
                material.setKnowledge(rs.getString(2));
                material.setLink(rs.getString(3));
                materialList.add(material);

            }
            return materialList;

        }finally {
            JDBCUtil.close(conn, ps, rs);
        }

    }

    @Override
    public Material getMaterials(String knowledge) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select link FROM material where knowledge like \"%\"?\"%\"";
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, knowledge);
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
    public List<Material> getSeries(String knowledge) throws SQLException {
        List<Material> materialList=new ArrayList<Material>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConn();
            String sql="select name,knowledge,link FROM material where knowledge like \"%\"?\"%\"";
            ps=conn.prepareStatement(sql);
            ps.setString(1,knowledge);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Material material=new Material();
                material.setName(rs.getString(1));
                material.setKnowledge(rs.getString(2));
                material.setLink(rs.getString(3));
                materialList.add(material);
            }
            return materialList;

        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

    }
}


