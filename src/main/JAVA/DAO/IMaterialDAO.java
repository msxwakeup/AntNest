package DAO;

import Mo.Material;

import java.sql.SQLException;
import java.util.List;

public interface IMaterialDAO {
    //按名字查询显示系列文件
    public List<Material> getMaterial(String names)throws SQLException;
    public Material getMaterials(String knowledge)throws SQLException;
    public boolean uploadMaterial(Material material)throws SQLException;
    //按知识点查询显示系列
    public List<Material> getSeries(String knowledge)throws SQLException;
    //按类型显示系列

}