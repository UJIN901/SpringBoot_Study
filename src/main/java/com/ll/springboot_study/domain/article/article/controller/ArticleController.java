package com.ll.springboot_study.domain.article.article.controller;

import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.service.ArticleService;
import com.ll.springboot_study.global.rsData.RsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired // 필드 주입, final은 뺀다. @Component가 붙은것만 해당.
    private ArticleService articleService;

    @GetMapping("/article/write")
    String showWrite(){
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData doWrite(String title, String body){

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

