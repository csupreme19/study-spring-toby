package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import java.util.List;

public class MySqlDao extends Dao {

    @Override
    public Connection getConnection() {
        return new MySqlConnection();
    }

    @Override
    public Member saveMember(Member member) {
        return memberMap.put(member.getId(), member);
    }

    @Override
    public Member getMember(String id) {
        return memberMap.get(id);
    }

    @Override
    public List<Member> getMembers() {
        return memberMap.values().stream().toList();
    }

    @Override
    public Member updateMember(String id, Member updateMember) {
        return memberMap.put(id, updateMember);
    }

    @Override
    public boolean deleteMember(String id) {
        memberMap.remove(id);
        return true;
    }

}
