package DAO;

import Mo.Items;

import java.util.List;

public interface ItemsDAO {
    //按类型查找题目
    List<Items> getItems(String catagroy);
    Items getitem(String catagroy,int num);


}
