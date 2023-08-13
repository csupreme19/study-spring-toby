package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = {MemberDao.class, PostgresqlConnectionMaker.class})
class MemberDaoTest {

    @Autowired
    MemberDao dao;

    @BeforeAll
    static void beforeAll() {
        log.info("테스트 시작");
    }

    @BeforeEach
    void setUp() {
        log.info("단위 테스트 시작");
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

    @AfterEach
    void tearDown() {
        log.info("단위 테스트 종료");
    }

    @AfterAll
    static void afterAll() {
        log.info("테스트 종료");
    }
}