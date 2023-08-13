package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

    private ThreadLocal<Integer> num = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int add(int i) {
        num.set(num.get() + i);
        return num.get();
    }

    private static MemberDao INSTANCE;

    public static synchronized MemberDao getInstance() {
        if (INSTANCE == null) INSTANCE = new MemberDao(new PostgresqlConnectionMaker());
        return INSTANCE;
    }

    private final ConnectionMaker connectionMaker;

    public MemberDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public static Map<Long, Member> memberMap = new HashMap<>();

    public Member saveMember(Member member) {
        return memberMap.put(member.getId(), member);
    }

    public Member getMember(Long id) {
        return memberMap.get(id);
    }

    public List<Member> getMembers() {
        return memberMap.values().stream().toList();
    }

    public Member updateMember(Long id, Member updateMember) {
        return memberMap.put(id, updateMember);
    }

    public boolean deleteMember(Long id) {
        memberMap.remove(id);
        return true;
    }

    public Member findMember(Long id) {
        return getMember(id);
    }
}
