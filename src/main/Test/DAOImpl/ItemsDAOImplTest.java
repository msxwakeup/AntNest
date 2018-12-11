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
        List<Items> list=itemsDAO.getItems("C语言");
        for(Items items:list)
            System.out.println(items);

    }
}