package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public Level upgradeLevels() {
        List<Member> members = memberDao.getAll();
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
