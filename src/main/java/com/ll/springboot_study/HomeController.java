package com.ll.springboot_study;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/calc8")
    @ResponseBody
    boolean showCalc8(int a, int b){
        return a > b;
    }

    @AllArgsConstructor // 클래스의 모든 필드의 인자를 받는 생성자를 자동으로 생성
    class Person {
        public String name;
        public int age;
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person showCalc9(String name, int age){
        return new Person(name, age);
    }

    @AllArgsConstructor
    @Getter // private 필드값을 불러오기 위한 어노테이션
    class Person2 {
        private String name;
        private int age;
    }

    @GetMapping("/calc10")
    @ResponseBody
    Person2 showCalc10(String name, int age){
        return new Person2(name, age);
    }

    @GetMapping("/calc11")
    @ResponseBody
    Map<String, Object> showCalc11(String name, int age){
        Map<String, Object> personMap = Map.of("name", name, "age", age); // Object를 활용해 여러 타입 받을 수 있도록 허용.
        return personMap;
    }

    @GetMapping("/calc12")
    @ResponseBody
    List<Person2> showCalc12(String name, int age){
        List<Person2> persons = new ArrayList<>(){{ // 값까지 설정해서 생성
            add(new Person2(name, age));
            add(new Person2(name, age));
            add(new Person2(name, age));
        }};
        return persons;
    }

    @GetMapping("/calc13")
    @ResponseBody
    String showCalc13(){
        return """
                <div>
                <input type="text" name="username" placeholder="이름을 입력하세요.">
                </div>
                """;
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14(){
        StringBuilder sb = new StringBuilder(); // 문자열을 이어 붙이는 것 보다 메모리 측면에서 빌더를 사용하는 것을 권장

        sb.append("<div>");
        sb.append("<h1>제목</h1>");
        sb.append("</div>");

        return sb.toString();
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15(){
        return """
                <div>
                <input type="text" name="username" placeholder="이름을 입력하세요." value="김멋사">
                </div>
                """;
    }

    @GetMapping("/calc16") // ResponseBody를 제거하면 리턴값에 해당하는 뷰 파일의 값이 출력된다.
    String showCalc16(){
        return "calc16";
    }

    @GetMapping("/calc17")
    String showCalc17(Model model){
        model.addAttribute("v1", "안녕"); // 뷰 단과 연결을 위한 속성 추가
        model.addAttribute("v2", "반가워");
        return "calc17";
    }

    int num = 0;

    @GetMapping("/calc18")
    @ResponseBody
    int showCalc18(){
        num++; // 인스턴스 변수로 증가되는 값이 적용된다.
        return num;
    }
}

