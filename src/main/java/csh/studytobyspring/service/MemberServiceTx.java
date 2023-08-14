package csh.studytobyspring.service;

import csh.studytobyspring.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
@RequiredArgsConstructor
public class MemberServiceTx implements MemberService {

    private final PlatformTransactionManager txManager;
    private MemberService memberService = new MemberServiceImpl(new MemberDao());

    public void upgradeLevels() {
        TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            memberService.upgradeLevels();
            txManager.commit(txStatus);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            throw e;
        }
    }
}
