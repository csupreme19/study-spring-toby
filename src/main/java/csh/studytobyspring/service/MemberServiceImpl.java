package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.model.Member;
import csh.studytobyspring.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Transactional

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void addChecked(Member member) {
        memberRepository.add(member);
    }

    @Override
    public void addUnchecked(Member member) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Member> findAll() {
        return memberRepository.getAll();
    }

    public Level upgradeLevels() {
        List<Member> members = memberRepository.getAll();
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
