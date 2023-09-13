package com.helloSpring.Service;

import com.helloSpring.Repository.JpaMemberRepository;
import com.helloSpring.Repository.MemberRepository;
import com.helloSpring.Repository.MemoryMemRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {
//    private final DataSource dataSource;
//    private final EntityManager em;

    private final MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//    }
}
