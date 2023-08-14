package csh.studytobyspring;

import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Client {

    private MemberServiceImpl memberService;

    void call() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(memberService);
        MemberService txMemberService = (MemberService) proxyFactoryBean.getObject();
    }


}
