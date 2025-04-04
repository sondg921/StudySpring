package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);  //회원을 반환하는데 null로 반환될 수 있기 때문에 null을 처리하는 방법중 하나인 optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}