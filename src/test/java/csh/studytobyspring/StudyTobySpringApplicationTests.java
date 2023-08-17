package csh.studytobyspring;

import csh.studytobyspring.config.MemberServiceFactory;
import csh.studytobyspring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudyTobySpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void notSingleton() {
        MemberServiceFactory factory = new MemberServiceFactory();

        MemberService memberService1 = factory.memberService();
        MemberService memberService2 = factory.memberService();

        System.out.println("memberService1=" + memberService1);
        System.out.println("memberService2=" + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void singleton() {
        MemberServiceFactory factory = new MemberServiceFactory();

        MemberService memberService1 = factory.memberServiceSingleton();
        MemberService memberService2 = factory.memberServiceSingleton();

        System.out.println("memberService1=" + memberService1);
        System.out.println("memberService2=" + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }


}
