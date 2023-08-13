package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
class MemberDaoTest {

    ApplicationContext ctx;
    MemberDao dao;

    @BeforeAll
    static void beforeAll() {
        log.info("테스트 시작");
    }

    @BeforeEach
    void setUp() {
        ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = ctx.getBean("memberDao", MemberDao.class);

        log.info("단위 테스트 시작");
    }

    @Test
    void getMember() {

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
        Member foundMember = dao.findMember(member.getId());

        Assertions.assertThat(member).isEqualTo(foundMember);

    }

    @AfterEach
    void tearDown() {
        ctx = null;
        dao = null;

        log.info("단위 테스트 종료");
    }

    @AfterAll
    static void afterAll() {
        log.info("테스트 종료");
    }
}