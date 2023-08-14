package csh.studytobyspring.service;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    private final PlatformTransactionManager txManager;

    public void updateLevels() {
        // 트랜잭션 경계설정 부분
        TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            upgradeLevel();
            // 트랜잭션 경계설정 부분
            txManager.commit(txStatus);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            throw e;
        }
    }

    private void upgradeLevel() {
        // 비즈니스 로직 부분
        List<Member> members = memberDao.getAll();
        for (Member member : members) {
            if (canUpgradeLevel(member)) upgradeLevel(member);
        }
    }

    private void upgradeLevel(Member member) {
        member.upgradeLevel();
    }

    private boolean canUpgradeLevel(Member member) {
        return member.getLevel().getNext() != null;
    }

}
