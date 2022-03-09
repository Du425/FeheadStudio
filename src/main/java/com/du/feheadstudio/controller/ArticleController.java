package com.du.feheadstudio.controller;


import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IArticleService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Du425
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/api/v1/user")
public class ArticleController {
    private IArticleService articleService;

    //todo 这部分什么作用
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/publish_article/{articleId}")
    public CommonResult publishArticle(@PathVariable String articleId, @RequestBody Article article) {

        return null;
    }
}

