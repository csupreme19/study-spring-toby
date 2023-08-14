package csh.studytobyspring.service;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;

import java.sql.Connection;

public class MemberService {

    public void updateLevel(Connection c, Member member) {
        member.updateLevel();
        memberDao.update(c, member);
    }

    MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
