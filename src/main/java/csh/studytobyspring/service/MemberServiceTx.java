package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class MemberServiceTx implements MemberService {

    private final PlatformTransactionManager txManager;
    private MemberService memberService = new MemberServiceImpl(new MemberDao());

    @Override
    public void addChecked(Member member) {

    }

    @Override
    public void addUnchecked(Member member) {

    }

    @Override
    public void clear() {
        
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

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
