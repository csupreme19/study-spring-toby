package csh.studytobyspring;

import csh.studytobyspring.config.TransactionHandler;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Proxy;

@Component
@RequiredArgsConstructor
public class Client {

    private final MemberServiceImpl memberService;

    private final PlatformTransactionManager txManager;

    void call() {
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(memberService);
        txHandler.setTransactionManager(txManager);
        MemberService txMemberServcice = (MemberService) Proxy.newProxyInstance(getClass().getClassLoader()
                , new Class[]{MemberService.class}, txHandler);
    }


}
