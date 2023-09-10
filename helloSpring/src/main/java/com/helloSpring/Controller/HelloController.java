package com.helloSpring.Controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String Hello(Model model) //
    {
        model.addAttribute("data", "Hello!!!!");
        // attributeValue에 뭔가 DB에서 데이터를 조회해와서 필요한 데이터를 표시할 수 있다!
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) //
    {
        model.addAttribute("name", name);
        // attributeValue에 뭔가 DB에서 데이터를 조회해와서 필요한 데이터를 표시할 수 있다!
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam(name = "name") String name) //
    {

        return "hello-template " + name;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    static class Hello{
        private String name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(name = "name") String name)
    {
        Hello hello = new Hello();
        hello.setName("s");
        return hello;
    }
}
/*
궁금했던점 : hello 문자열을 리턴하는게, 내가 예전에 했던 프로젝트에서는 그냥 문자열 반환이었는데, 여기서는 템플릿 엔진한테 hello.html을 찾아
표시하도록 작동했음. 뭐가 차이였지?

https://mangkyu.tistory.com/49

내가 예전에 했던

* */