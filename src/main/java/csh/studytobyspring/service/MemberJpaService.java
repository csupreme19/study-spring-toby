package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.exception.RuntimeSQLException;
import csh.studytobyspring.model.Member;
import csh.studytobyspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberJpaService implements MemberService {

    private final MemberRepository memberRepository;

    private void internal() {
        log.info("internal call()");
    }

    public void external() {
        log.info("external call()");
        internal();
    }

    @Override
    public void addChecked(Member member) throws SQLException {
        memberRepository.save(member);
        if (member.getId() == 999L) throw new SQLException();
    }

    @Override
    public void addUnchecked(Member member) {
        memberRepository.save(member);
        if (member.getId() == 999L) throw new RuntimeSQLException();
    }

    @Override
    public void clear() {
        memberRepository.deleteAll();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Level upgradeLevels() {
        List<Member> members = memberRepository.findAll();
        if (isEmpty(members)) return Level.BRONZE;
        for (Member member : members) {
            if (canUpgradeLevel(member)) upgradeLevel(member);
        }
        return members.get(0).getLevel();
    }

    private void upgradeLevel(Member member) {
        member.upgradeLevel();
    }

    private boolean canUpgradeLevel(Member member) {
        return member.getLevel().getNext() != null;
    }
}
