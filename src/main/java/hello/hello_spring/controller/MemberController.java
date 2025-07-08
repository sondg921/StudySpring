package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    //MemberService, MemoryMemberRepository 에도 어노테이션 추가
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // url창에 주소를 치는 것은 GetMapping, 주로 조회할때 사용
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // PostMapping은 데이터를 폼 같은곳에 넣어 전달할때 사용
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member(); // Member import 할때 우리가 만든 코드를 import
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}