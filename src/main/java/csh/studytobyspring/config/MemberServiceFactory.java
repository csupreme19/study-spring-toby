package csh.studytobyspring.config;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;

public class MemberServiceFactory {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemberDao());
    }

}
