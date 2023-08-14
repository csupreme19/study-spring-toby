package csh.studytobyspring.service;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public void upgradeLevels() {
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
