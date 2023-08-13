package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {

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

    private static Dao INSTANCE;

    public static synchronized Dao getInstance() {
        if (INSTANCE == null) INSTANCE = new Dao(new PostgresqlConnectionMaker());
        return INSTANCE;
    }

    private final ConnectionMaker connectionMaker;

    public Dao(ConnectionMaker connectionMaker) {
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

}
