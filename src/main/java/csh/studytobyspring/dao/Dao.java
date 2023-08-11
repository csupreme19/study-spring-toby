package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Dao {

    public static Map<String, Member> memberMap = new HashMap<>();

    public abstract Connection getConnection();

    public abstract Member saveMember(Member member);

    public abstract Member getMember(String id);

    public abstract List<Member> getMembers();

    public abstract Member updateMember(String id, Member updateMember);

    public abstract boolean deleteMember(String id);

}
