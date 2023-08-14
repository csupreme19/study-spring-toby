package csh.studytobyspring;

import csh.studytobyspring.config.TransactionProxyFactoryBean;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Client {

    private final ApplicationContext ctx;

    private MemberServiceImpl memberService;

    void call() {
        TransactionProxyFactoryBean txProxyFactoryBean = ctx.getBean("&memberService", TransactionProxyFactoryBean.class);
        txProxyFactoryBean.setTarget(memberService);
        MemberService txMemberService = (MemberService) txProxyFactoryBean.getObject();
    }


}
