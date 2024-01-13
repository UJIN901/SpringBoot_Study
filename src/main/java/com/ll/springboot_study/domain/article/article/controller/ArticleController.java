package com.ll.springboot_study.domain.article.article.controller;

import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.service.ArticleService;
import com.ll.springboot_study.global.rq.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Getter
    @Setter
    public static class WriteForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;

    }

    @PostMapping("/article/write")
    String doWrite(@Valid WriteForm writeForm){

        Article article = articleService.write(writeForm.title, writeForm.body);
        String msg = "id %d, article created".formatted(article.getId());

        return "redirect:/article/list?msg=" + msg;
    }

    @Getter
    @Setter
    public static class ModifyForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;

    }

    @GetMapping("/article/modify/{id}")
    String modify(Model model,  @PathVariable long id){
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/modify";
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

    @GetMapping("/article/list")
    String showList(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "article/list";
    }

    @GetMapping("/article/detail/{id}")
    String showDetail(Model model,  @PathVariable long id){
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/detail";
    }

    @GetMapping("/article/delete/{id}")
    String delete(@PathVariable long id){
        articleService.delete(id);
        String msg = "id %d, article deleted".formatted(id);
        return "redirect:/article/list?msg=" + msg;
    }
}

