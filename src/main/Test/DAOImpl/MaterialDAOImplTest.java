package DAOImpl;

import DAO.IMaterialDAO;
import Mo.Material;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaterialDAOImplTest {

    @Test
    public void getMaterial() {
        List<Material> materialList=new ArrayList<Material>();
        Material material=new Material();
        IMaterialDAO dao=new MaterialDAOImpl();
        try {
            materialList=dao.getMaterial("数据");
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(materialList.size());

    }
}