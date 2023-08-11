package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresqlDao {

    private static Map<String, Member> memberMap = new HashMap<>();

    public Member saveMember(Member member) {
        return memberMap.put(member.getId(), member);
    }

    public Member getMember(String id) {
        return memberMap.get(id);
    }

    public List<Member> getMembers() {
        return memberMap.values().stream().toList();
    }

    public Member updateMember(String id, Member updateMember) {
        return memberMap.put(id, updateMember);
    }

    public boolean deleteMember(String id) {
        memberMap.remove(id);
        return true;
    }

}
