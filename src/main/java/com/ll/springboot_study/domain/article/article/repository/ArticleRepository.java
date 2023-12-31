package com.ll.springboot_study.domain.article.article.repository;

import com.ll.springboot_study.domain.article.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    private List<Article> articles = new ArrayList<>();

    public void save(Article article) {
        if (article.getId() == null){
            article.setId(articles.size() + 1L);
        }
        articles.add(article);
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}
