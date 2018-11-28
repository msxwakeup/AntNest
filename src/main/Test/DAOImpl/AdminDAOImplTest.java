package DAOImpl;

import DAO.IAdminDAO;
import Mo.Adminer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminDAOImplTest {

    @Test
    public void getAdmin() {
        IAdminDAO adminDAO=new AdminDAOImpl();
        Adminer adminer=new Adminer();
        adminer=adminDAO.getAdmin("zhangwei","123456");
        System.out.println("111：："+adminer);
    }

    @Test
    public void checkAdmin() {
        IAdminDAO adminDAO=new AdminDAOImpl();
        Adminer adminer=new Adminer();
        boolean flag=adminDAO.CheckAdmin("zhangwei","123456");
        System.out.println(flag);
    }
}