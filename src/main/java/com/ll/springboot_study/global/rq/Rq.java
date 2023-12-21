package com.ll.springboot_study.global.rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope // 요청이 오는 잠깐의 시간동안만 존재하고 사라진다. 수명이 짧은측에 맞춘다.
@Component
public class Rq {

    private  final HttpServletRequest req;
    private  final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }
}
