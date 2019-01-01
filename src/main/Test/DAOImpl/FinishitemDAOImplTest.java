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
        finishitem.setFinishtimes(1);
        finishitem.setFiIdnum(5);
        finishitem.setItcatagroy("C");
        finishitem.setItId(4);
        finishitem.setYanswer("");
        boolean flag=dao.yetfinitem(finishitem);
        System.out.println(flag);
    }

    @Test
    public void getanwser() {
        Finishitem finishitem=new Finishitem();
        int memid=2;
        int fiidnum=1;
        int finishtimes=1;
        String catagroy="C";
        String answer=null;
        answer=dao.getanwser(memid,fiidnum,finishtimes,catagroy);
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

    @Test
    public void updatefinishitem() {
        Finishitem finishitem=new Finishitem();
        finishitem.setMemId(2);
        finishitem.setFinishtimes(1);
        finishitem.setItId(1);
        finishitem.setYanswer("Q");
        boolean flag=dao.updatefinishitem(finishitem);
        System.out.println(flag);
    }

    @Test
    public void getanwserUseritid() {
        int memid=2;
        int itid=1;
        int fintime=2;
        String answer=dao.getanwserUseritid(memid,itid,fintime);
        System.out.println(answer);
    }
}