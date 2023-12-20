package com.ll.springboot_study.domain.article.article.service;


import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.repository.ArticleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 한 번만 생성되고 재사용된다.
public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepository();

    public Article write(String title, String body) {
        Article article = new Article(title, body);
        articleRepository.save(article);
        return article;
    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
