package com.helloSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String Hello(Model model) //
    {
        model.addAttribute("data", "Hello!!!!");
        return "hello";
    }
}
/*
궁금했던점 : hello 문자열을 리턴하는게, 내가 예전에 했던 프로젝트에서는 그냥 문자열 반환이었는데, 여기서는 템플릿 엔진한테 hello.html을 찾아
표시하도록 작동했음. 뭐가 차이였지?

https://mangkyu.tistory.com/49

내가 예전에 했던

* */