package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
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

    public Level upgradeLevels() {
        TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
        Level result = null;
        try {
            result = memberService.upgradeLevels();
            txManager.commit(txStatus);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            throw e;
        }
        return result;
    }
}
