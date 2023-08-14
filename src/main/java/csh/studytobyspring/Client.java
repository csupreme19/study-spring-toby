package csh.studytobyspring;

import csh.studytobyspring.advice.TransactionAdvice;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Client {

    private MemberServiceImpl memberService;

    void call() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(memberService);

        TransactionAdvice advice = new TransactionAdvice();
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("get*");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        proxyFactoryBean.addAdvisor(advisor);

        MemberService txMemberService = (MemberService) proxyFactoryBean.getObject();


    }


}
