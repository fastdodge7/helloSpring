package com.helloSpring.Controller;


import com.helloSpring.Domain.Member;
import com.helloSpring.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
* Controller 어노테이션이 붙게 되면 어떤 일이 일어날까?
* Spring이 최초 실행될 때, Spring은 @Controller 어노테이션이 붙은 클래스를 찾고, 이로부터 객체를 생성하여
* Spring Container에 담아두게 된다.
* */


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("members")
    public String scanMembers(Model model){

        return "membersPage";
    }

    @GetMapping("members/new")
    public String createForm(String name, Model model){

        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    // MemeberForm이라는 클래스 객체를 파라미터로 받는다. -> RequestParam이랑 비슷하다고 보면 된다.
    // html 폼에서 데이터를 전송하면,(request body에 Json으로 들어옴)
    // Spring에서 해당 객체를 MemberForm 클래스의 필드명과 매칭시켜서 MemberForm 객체를 만들어 파라미터로 넣어준다.
    // https://ittrue.tistory.com/244
    public String registNewMember(@ModelAttribute MemberForm form){
        Member newMember = Member.builder()
                .name(form.getName()).build();
        memberService.join(newMember);
        return "redirect:/";
    }

    @GetMapping("members/memberList")
    public String list(Model model){
        List<Member> memberList = memberService.findAllMembers();
        model.addAttribute("members", memberList);
        return "members/memberList";
    }


}
