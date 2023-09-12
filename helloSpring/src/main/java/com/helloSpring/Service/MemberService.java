package com.helloSpring.Service;

import com.helloSpring.Domain.Member;
import com.helloSpring.Repository.MemberRepository;
import com.helloSpring.Repository.MemoryMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class MemberService {
    // MemberRepository라는 클래스의 의존하고있는데, 이를 생성자를 통해 주입받는다. Dependency Injection.
    // 단, 아직은 스프링에서 직접 주입해 주는 것이 아니므로, 스프링에 의한 DI는 아니다.
    private final MemberRepository repository;

    public Long join(Member member) {
        validateDuplicatedName(member);
        Member saveResult = repository.save(member);
        return saveResult.getId();
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    public Member findOne(Long id){
        Optional<Member> member = repository.findById(id);
        if(member.isEmpty()) throw new IllegalStateException("id : " + id + "에 해당하는 멤버가 없습니다.");
        return member.get();
    }

    private void validateDuplicatedName(Member member) {
        Optional<Member> sameNameMember = repository.findByName(member.getName());
        sameNameMember.ifPresent(mem -> {
            throw new IllegalStateException("중복된 이름은 허용되지 않습니다.");
        });
    }
}
