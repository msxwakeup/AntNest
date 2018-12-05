package DAO;

import Mo.Member;

public interface IMemberDAO {
    boolean addMember(Member member);
    boolean checkMember(String memNo, String pwd);
    boolean resetpwd(String memNo, String pwd);
    Member getMember(String memNo);
}
