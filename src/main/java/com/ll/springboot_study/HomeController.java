package com.ll.springboot_study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 해당 클래스가 Controller임을 인지한다.
public class HomeController {

    @GetMapping("/") // 해당 url 요청을 받으면 실행된다.
    @ResponseBody// 이 함수의 return 값을 그대로 브라우저에 출력하라는 의미
    String showMain(){
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }
}

