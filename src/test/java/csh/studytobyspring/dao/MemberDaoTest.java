package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberDaoTest {

    MemberDeleteAll dao;

    @BeforeEach
    void setUp() {
        dao = new MemberDeleteAll(new PostgresqlConnectionMaker());
    }

    @Test
    void getMember() {

        Member member = new Member(1L, "최승훈", 10);
        dao.saveMember(member);
        Member member2 = dao.getMember(1L);

        assertThat(member.getName()).isEqualTo(member.getName());
        assertThat(member.getAge()).isEqualTo(member.getAge());

    }

    @Test
    void findMember() {

        Member member = new Member(1L, "최승훈", 10);
        dao.saveMember(member);
        Member foundMember = dao.findMember(member.getId());

        assertThat(member).isEqualTo(foundMember);

    }

}