package com.ll.springboot_study.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스가 Controller임을 인지한다.
public class HomeController {

    @GetMapping("/") // 해당 url 요청을 받으면 실행된다.
    String showMain(){
        return "redirect:/article/list";
    }

}

