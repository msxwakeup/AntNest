package DAO;

import Mo.Finishitem;

public interface IFinishitemDAO {
    boolean yetfinitem(Finishitem finishitem);
    String getanwser(int memid,int fiidnum,int finishtimes,String catagroy);//得到答案
    int getfinishtimes(int memid,String catagroy);   //得到第几次做题
    int getnowfiidnum(int memid,int finishtime,String catagroy);  //得到当前次数的第几题
    boolean updatefinishitem(Finishitem finishitem);
    String getanwserUseritid(int memid,int itid,int finishtimes);
}
