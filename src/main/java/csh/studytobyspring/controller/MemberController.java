package csh.studytobyspring.controller;

import csh.studytobyspring.service.MemberService;
import org.springframework.stereotype.Component;

@Component
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
