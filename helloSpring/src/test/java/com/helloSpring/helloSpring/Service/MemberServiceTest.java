package com.helloSpring.helloSpring.Service;

import com.helloSpring.Domain.Member;
import com.helloSpring.Repository.MemberRepository;
import com.helloSpring.Repository.MemoryMemRepository;
import com.helloSpring.Service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    private MemberService memberService;
    private MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void resetRepository(){
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입_테스트()
    {
        // given
        Member member = Member.builder()
                .name("Spring").build();

        // when
        Long savedId = memberService.join(member);

        // then
        Member foundMember = memberService.findOne(savedId);
        Assertions.assertEquals(member.getId(), savedId);
        Assertions.assertEquals(member, foundMember);
    }

    @Test
    public void 중복이름_회원가입_예외처리_테스트()
    {
        // given
        Member member = Member.builder()
                .name("spring1").build();
        Member member2 = Member.builder()
                .name("spring1").build();

        // when
        Long savedId = memberService.join(member);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertEquals(e.getMessage(), "중복된 이름은 허용되지 않습니다.");
//        try{
//            Long savedId2 = memberService.join(member2);
//            fail("예외가 발생해야 합니다." + savedId2);
//        }catch(IllegalStateException err){
//
//        }

        // then
    }

    @Test
    public void 전체유저조회_테스트()
    {

    }

    @Test
    public void findOne_테스트()
    {

    }
}
