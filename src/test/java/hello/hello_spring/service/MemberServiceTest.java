package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // 외부에서 멤버 리포지토리를 넣어준 이런것을 DI(의존성 주입)라고 한다
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //GivenWhenThen 패턴
        //given (이런 상황이 주어져서)
        Member member = new Member();
        member.setName("spring");

        //when (이걸 실행했을 때)
        Long saveId = memberService.join(member);

        //then (이런 결과가 나와야 한다)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 예외 테스트
    @Test
    // 테스트 작성에서는 한글로도 많이 작성함
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        // memberService.join(member2)를 실행하면 앞의 예외가 발생해야 한다는 코드
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

/* 아래와 같이해도 무방
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}