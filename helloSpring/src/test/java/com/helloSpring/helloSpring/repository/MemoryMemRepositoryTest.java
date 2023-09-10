package com.helloSpring.helloSpring.repository;


import com.helloSpring.Domain.Member;
import com.helloSpring.Repository.MemberRepository;
import com.helloSpring.Repository.MemoryMemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemRepositoryTest {
    MemberRepository repository = new MemoryMemRepository();
    // 테스트 할 때, repository가 메소드마다 초기화 되지 않아서, 테스트 3개를 돌릴 때 예상하지 못한 에러가 발생할 수 있음.
    // 반드시 clear 해줄것.


    @AfterEach
    public void resetRepository(){
        repository.clearStore();
    }

    @Test
    public void 멤버저장_테스트()
    {
        Member member = Member.builder()
                .name("Member").build();

        repository.save(member);


        Member idResult = repository.findById(member.getId()).get();
        Member nameResult = repository.findByName(member.getName()).get();

        Assertions.assertEquals(member, idResult);
        Assertions.assertEquals(member, nameResult);
    }

    @Test
    public void findById_테스트()
    {
        Member member = Member.builder()
                .name("spring1").build();
        repository.save(member);

        Member member2 = Member.builder()
                .name("spring2").build();
        repository.save(member2);

        Member nameResult = repository.findByName("spring1").get();


        Assertions.assertEquals(member, nameResult);
        Assertions.assertNotEquals(member2, nameResult);
    }

    @Test
    public void findAll_테스트()
    {
        Member member = Member.builder()
                .name("spring1").build();
        repository.save(member);

        Member member2 = Member.builder()
                .name("spring2").build();
        repository.save(member2);

        Assertions.assertEquals(repository.findAll().size(), 2);
    }

}
