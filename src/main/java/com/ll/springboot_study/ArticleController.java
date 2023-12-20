package com.ll.springboot_study;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite(){
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    RsData<Article> doWrite(String title, String body){

        Article article = new Article(articles.size()+1, title, body);
        RsData<Article> rs = new RsData<>("S-1", "%d번 게시물이 작성되었습니다.".formatted(article.getId()), article);

        articles.add(article);

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
        return articles;
    }
}
@AllArgsConstructor
@Getter
class Article{
    private long id;
    private String title;
    private String body;
}

@AllArgsConstructor
@Getter
class RsData<T>{
    private String resultCode;
    private String msg;
    private T data;
}
