package com.du.feheadstudio.controller;


import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.SimpleArticle;
import com.du.feheadstudio.pojo.ArticleSearchInfo;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Du425
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    private IArticleService articleService;

    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 更新文章
     *
     * @param articleId
     * @param article
     * @return
     */
    @PostMapping("/publish/{articleId}")
    public CommonResult publishArticle(@PathVariable String articleId, @RequestBody Article article) {
        return null;
    }

    /**
     * 获取所有文章 (简略)
     *
     * @param userId
     * @return
     */
    @GetMapping("/get/all/{userId}")
    public CommonResult getArticleList(@PathVariable String userId) {
        return null;
    }

    /**
     * 获取已存在的文章(详细)
     *
     * @param articleId
     * @return
     */
    @GetMapping("/get/{articleId}")
    public CommonResult getArticle(@PathVariable String articleId) {
        return null;
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @DeleteMapping("/delete/{articleId}")
    public CommonResult deleteArticle(@PathVariable String articleId) {
        return null;
    }

    @PostMapping("/search")
    public CommonResult searchArticle(@RequestBody ArticleSearchInfo info) {
        List<SimpleArticle> list = articleService.searchArticleList(info);
       return CommonResult.builder()
               .code(200)
               .status("ok")
               .message("")
               .data(list)
               .build();

    }

}

