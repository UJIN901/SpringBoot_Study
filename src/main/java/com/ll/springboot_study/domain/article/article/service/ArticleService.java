package com.ll.springboot_study.domain.article.article.service;


import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

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
