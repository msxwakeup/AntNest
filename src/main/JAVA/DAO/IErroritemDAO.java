package DAO;

import Mo.ErrorItem;

public interface IErroritemDAO {
    boolean updateErroritems(ErrorItem erroritem);
    ErrorItem geterroritems(int mid,int itid);
    int getItemtimes(int mid,int itid);
    boolean updaterrortimes(ErrorItem erroritem);
}
