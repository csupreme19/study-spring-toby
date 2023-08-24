//package csh.studytobyspring.config;
//
//import csh.studytobyspring.controller.MemberController;
//import csh.studytobyspring.repository.MemberRepository;
//import csh.studytobyspring.service.MemberService;
//import csh.studytobyspring.service.MemberServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration(proxyBeanMethods = true)
//public class AppConfig {
//
//    @Bean
//    MemberController memberController() {
//        return new MemberController(memberService());
//    }
//
//    @Bean
//    MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    MemberRepository memberRepository() {
//        return new MemberRepository();
//    }
//
//}
