package com.helloSpring.Repository;

import com.helloSpring.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<Long, Member>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    @Override
    public void clearStore() { store.clear(); }
}