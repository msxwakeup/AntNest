package DAO;

import Mo.Member;

public interface IMemberDAO {
    boolean addMember(Member member);
    boolean checkMember(String memNo, String pwd);
    boolean resetpwd(String memNo, String pwd);
    public Member getMember(int memNo)throws Exception;
}
