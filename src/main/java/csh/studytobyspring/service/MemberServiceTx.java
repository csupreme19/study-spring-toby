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

    private final MemberDao memberDao;
    private final PlatformTransactionManager txManager;
    private final MemberService memberService = new MemberServiceImpl(memberDao);

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
