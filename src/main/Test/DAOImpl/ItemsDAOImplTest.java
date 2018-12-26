package DAOImpl;

import DAO.ItemsDAO;
import Mo.Items;
import org.junit.Test;

import java.awt.print.Book;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsDAOImplTest {

    @Test
    public void getItems() {

        ItemsDAO itemsDAO=new ItemsDAOImpl();
        List<Items> list=itemsDAO.getItems("C");
        System.out.println(list.get(0));
    }

    @Test
    public void getitem() {
        ItemsDAO itemsDAO=new ItemsDAOImpl();
        int cl=2;
        Items item=itemsDAO.getitem("C",cl);
        System.out.println(item);
    }
}