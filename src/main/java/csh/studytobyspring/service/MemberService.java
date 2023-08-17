package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.model.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberService {

    void addChecked(Member member) throws SQLException;

    void addUnchecked(Member member);

    void clear();

    List<Member> findAll();

    Level upgradeLevels();

}
