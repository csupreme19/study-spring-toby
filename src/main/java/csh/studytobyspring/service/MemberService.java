package csh.studytobyspring.service;

import csh.studytobyspring.dao.MemberDao;

public class MemberService {

    MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
