package com.ll.springboot_study.global.app;

import com.ll.springboot_study.domain.article.article.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    List<Article> articles(){
        return new java.util.LinkedList<>();
    }
}
