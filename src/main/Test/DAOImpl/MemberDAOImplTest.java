package DAOImpl;

import DAO.IMemberDAO;
import Mo.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberDAOImplTest {
    IMemberDAO dao=new MemberDAOImpl();
    @Test
    public void checkMember() {
        boolean flag=dao.checkMember("20001","123456");
        System.out.println(flag);
    }

    @Test
    public void resetpwd() {
        boolean flag=dao.resetpwd("20001","123");
        System.out.println(flag);
    }
}