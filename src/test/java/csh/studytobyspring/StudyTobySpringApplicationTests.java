package csh.studytobyspring;

import csh.studytobyspring.config.MemberServiceFactory;
import csh.studytobyspring.repository.MemberRepository;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    @Test
    void singletonApplicationContext() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MemberServiceImpl.class, MemberRepository.class);

        MemberService memberService1 = ctx.getBean(MemberService.class);
        MemberService memberService2 = ctx.getBean(MemberService.class);

        System.out.println("memberService1=" + memberService1);
        System.out.println("memberService2=" + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }


}
