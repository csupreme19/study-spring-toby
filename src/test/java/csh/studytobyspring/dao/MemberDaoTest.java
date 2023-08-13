package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoTest {

    @Autowired
    MemberDao dao;

    @Test
    void getMember() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean("memberDao", MemberDao.class);
        Member member = new Member(1L, "최승훈", 10);
        dao.saveMember(member);
        Member member2 = dao.getMember(1L);

        Assertions.assertThat(member.getName()).isEqualTo(member.getName());
        Assertions.assertThat(member.getAge()).isEqualTo(member.getAge());

    }

    @Test
    void findMember() {

        Member member = new Member(1L, "최승훈", 10);
        dao.saveMember(member);
        Member foundMember = dao.findMember();

        Assertions.assertThat(member).isEqualTo(foundMember);

    }

}