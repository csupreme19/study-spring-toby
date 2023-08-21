package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.dao.TeamDao;
import csh.studytobyspring.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Transactional

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    private TeamDao teamDao = new TeamDao();

    @Override
    public void addChecked(Member member) {
        memberDao.add(member);

//        Team team = new Team(1L, "teamA", List.of(member));
//        teamDao.add(team);
    }

    @Override
    public void addUnchecked(Member member) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Member> findAll() {
        return memberDao.getAll();
    }

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
