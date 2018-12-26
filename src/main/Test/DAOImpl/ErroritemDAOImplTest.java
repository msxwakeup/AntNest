package DAOImpl;

import DAO.IErroritemDAO;
import Mo.ErrorItem;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ErroritemDAOImplTest {
    IErroritemDAO erroritemDAO=new ErroritemDAOImpl();
    @Test
    public void updateErroritems() {

        ErrorItem errorItem=new ErrorItem();
        errorItem.setMemId(2);
        errorItem.setItId(2);
        errorItem.setTimes(1);
        errorItem.setYanswer("A");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String x=df.format(new Date());
        errorItem.setTime(x);
        boolean flag=erroritemDAO.updateErroritems(errorItem);
        System.out.println(flag);
    }

    @Test
    public void geterroritems() {
        ErrorItem errorItem=erroritemDAO.geterroritems(2,2);
        System.out.println(errorItem);

    }

    @Test
    public void getItemtimes() {
        int x=erroritemDAO.getItemtimes(0,2);
        System.out.println(x);
    }

    @Test
    public void updaterrortimes() {
        ErrorItem errorItem=new ErrorItem();
        errorItem.setMemId(2);
        errorItem.setItId(1);
        errorItem.setTimes(5);
        errorItem.setYanswer("D");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String x=df.format(new Date());
        errorItem.setTime(x);
        boolean flag=erroritemDAO.updaterrortimes(errorItem);
        System.out.println(flag);
    }
}