package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    //MemberService, MemoryMemberRepository 에도 어노테이션 추가
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}