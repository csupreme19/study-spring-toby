package csh.studytobyspring.dao;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MemberDaoTest {

    static class MockMemberDao extends MemberDao {
        private Map<Long, Member> members = new HashMap<>();

        @Override
        public Member add(Member member) {
            members.put(member.getId(), member);
            return member;
        }

        @Override
        public List<Member> getAll() {
            return members.values().stream().toList();
        }
    }

    @Test
    @DisplayName("멤버 조회 테스트")
    void getMember() {
        MemberDao dao = new MockMemberDao();
        Member member = new Member(1L, "최승훈", 10, Level.BRONZE);
        dao.add(member);
        Member foundMember = dao.getAll().get(0);

        assertThat(member.getName()).isEqualTo(foundMember.getName());
        assertThat(member.getAge()).isEqualTo(foundMember.getAge());
    }

}