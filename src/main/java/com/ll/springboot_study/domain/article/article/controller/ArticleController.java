package com.ll.springboot_study.domain.article.article.controller;

import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.service.ArticleService;
import com.ll.springboot_study.global.rq.Rq;
import com.ll.springboot_study.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor // 사용시 final 붙은 필드에 대한 생성자를 생성해준다.
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;


    @GetMapping("/article/write")
    String showWrite(){
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData doWrite(String title, String body){
        if(title == null || title.trim().length() == 0){ // JavaScript 기능을 끄면 실행되지 않는 유효성 검사를 위한 로직 추가
            return new RsData<>("F-1", "제목을 입력해주세요.");
        }
        if(body == null || body.trim().length() == 0){
            return new RsData<>("F-2", "내용을 입력해주세요.");
        }

        Article article = articleService.write(title, body);
        RsData<Article> rs = new RsData<>("S-1", "%d번 게시물이 작성되었습니다.".formatted(article.getId()), article);

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
        return articleService.findAll();
    }
}

