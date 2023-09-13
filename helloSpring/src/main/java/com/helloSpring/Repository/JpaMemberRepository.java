package com.helloSpring.Repository;

import com.helloSpring.Domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // 식별자(무슨 클래스를 사용하는지, 그리고 id를 주면 조회가 가능)
        // 이렇게 메서드 하나로 find를 하는 것은 PK를 이용해서만 가능하고, 다른 name이나 다른 컬럼으로 find를 해야 하면 SQL을 작성해야 한다.
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {

        System.out.println("회원등록 가즈아");
        Optional<Member> member = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
        return member;
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return memberList;
    }

}
