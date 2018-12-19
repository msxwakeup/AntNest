package DAO;

import Mo.Member;

import java.sql.SQLException;

public interface IMemberDAO {
    boolean addMember(Member member);
    boolean checkMember(String memNo, String pwd);
    boolean resetpwd(String memNo, String pwd);
    Member getMember(String memNo);
    //更新头像
    public boolean updateMemberHeadImg(Member member) throws SQLException;
    //修改个人信息
    public boolean updateMemberInformation(String mName,Integer mAge,String mGender,String memNo) throws SQLException;
}
