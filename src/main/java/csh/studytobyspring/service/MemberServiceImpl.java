package csh.studytobyspring.service;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.model.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    // 서블릿 종속, 엄밀히 POJO 아님
    public void memberSession(HttpSession session) {
        String sessionId = String.valueOf(session.getAttribute("JSESSIONID"));
        if (sessionId == null) {
            session.setAttribute("JSESSIONID", UUID.randomUUID());
        }
    }

    // 서블릿 종속, 엄밀히 POJO 아님
    public void memberLog(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        log.info(remoteAddr);
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
