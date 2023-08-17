package csh.studytobyspring.config;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;

public class MemberServiceFactory {

    private static MemberService INSTANCE;

    public MemberService memberServiceSingleton() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new MemberServiceImpl(new MemberDao());
        return INSTANCE;
    }

    public MemberService memberService() {
        return new MemberServiceImpl(new MemberDao());
    }

}
