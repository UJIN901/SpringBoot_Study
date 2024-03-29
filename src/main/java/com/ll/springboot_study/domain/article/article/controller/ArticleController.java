package com.ll.springboot_study.domain.article.article.controller;

import com.ll.springboot_study.domain.article.article.entity.Article;
import com.ll.springboot_study.domain.article.article.service.ArticleService;
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

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor // 사용시 final 붙은 필드에 대한 생성자를 생성해준다.
public class ArticleController {
    private final ArticleService articleService;


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
        String msg = "%d번 게시물 생성되었습니다.".formatted(article.getId());

        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

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

    @PostMapping("/article/modify/{id}")
    String modify(@PathVariable long id, @Valid ModifyForm modifyForm){
        articleService.modify(id, modifyForm.title, modifyForm.body);
        String msg = "%d번 게시물 수정되었습니다.".formatted(id);

        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return "redirect:/article/list?msg=" + msg;
    }

    @GetMapping("/article/modify/{id}")
    String modify(Model model,  @PathVariable long id){
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/modify";
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
        String msg = "%d번 게시물 삭제되었습니다.".formatted(id);

        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return "redirect:/article/list?msg=" + msg;
    }
}

