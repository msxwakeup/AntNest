package DAOImpl;

import DAO.IFinishitemDAO;
import Mo.Finishitem;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class FinishitemDAOImplTest {
    IFinishitemDAO dao=new FinishitemDAOImpl();

    @Test
    public void yetfinitem() {
        Finishitem finishitem=new Finishitem();
        finishitem.setMemId(1);

        finishitem.setItId(4);
        finishitem.setYanswer("B");
        boolean flag=dao.yetfinitem(finishitem);
        System.out.println(flag);
    }

    @Test
    public void getanwser() {
        Finishitem finishitem=new Finishitem();
        int memid=1;
        int fiidnum=2;
        int finishtimes=1;
        String catagroy="C";
        String answer=dao.getanwser(memid,fiidnum,finishtimes,catagroy);
        System.out.println(answer);
    }

    @Test
    public void getfinishtimes() {
        int memid=1;
        String catagroy="C";
        int num=dao.getfinishtimes(memid,catagroy);
        System.out.println(num);

    }

    @Test
    public void getnowfiidnum() {
        int memid=1;
        String catagroy="C";
        int fitime=1;
        int num=dao.getnowfiidnum(memid,fitime,catagroy);
        System.out.println(num);

    }
}