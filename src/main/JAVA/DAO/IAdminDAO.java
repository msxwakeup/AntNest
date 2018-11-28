package DAO;

import Mo.Adminer;

public interface IAdminDAO {
    //注册

    //登录
    Adminer getAdmin(String admName,String admPwd);
    boolean CheckAdmin(String name,String pwd);
}
