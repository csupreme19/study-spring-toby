package csh.studytobyspring.config;

import csh.studytobyspring.repository.MemberRepository;
import csh.studytobyspring.service.MemberService;
import csh.studytobyspring.service.MemberServiceImpl;

public class MemberServiceFactory {

    private static MemberService INSTANCE;

    public MemberService memberServiceSingleton() {
        if (INSTANCE != null) return INSTANCE;
        INSTANCE = new MemberServiceImpl(new MemberRepository());
        return INSTANCE;
    }

    public MemberService memberService() {
        return new MemberServiceImpl(new MemberRepository());
    }

}
