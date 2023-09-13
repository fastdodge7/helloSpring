package com.helloSpring.Repository;

import com.helloSpring.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    public Optional<Member> findByName(String name);
}
