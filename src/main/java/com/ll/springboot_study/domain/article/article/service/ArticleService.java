package com.ll.springboot_study.domain.article.article.service;


import com.ll.springboot_study.domain.article.article.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    private List<Article> articles = new ArrayList<>();

    public Article write(String title, String body) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);
        return article;
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}
