package com.ll.springboot_study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b){ // int의 경우 null값을 가질 수 없기에 오류발생
        return "계산기";
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b){ // Integer의 경우 null 값을 허용하기에 가능하다.
        return "계산기";
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(int a, int b){ // url에 값을 같이 넣어서 보내게 된다면(null 값이 아닌) 가능하다.
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(@RequestParam(defaultValue = "0") int a,@RequestParam(defaultValue = "0") int b){ // 값이 없을 경우 defaultValue값이 들어간다.
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(@RequestParam(defaultValue = "0") double a,@RequestParam(defaultValue = "0") double b){
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    String showCalc6(@RequestParam(defaultValue = "0") String a,@RequestParam(defaultValue = "0") String b){
        return "계산 결과 : %s".formatted(a + b);
    }

    @GetMapping("/calc7")
    @ResponseBody
    int showCalc7(int a, int b){
        return a + b; // 결과값이 문자열로 변형되서 출력된다.
    }
}

