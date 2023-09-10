package com.helloSpring.Service;

import com.helloSpring.Repository.MemberRepository;
import com.helloSpring.Repository.MemoryMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemRepository();
    }
}
