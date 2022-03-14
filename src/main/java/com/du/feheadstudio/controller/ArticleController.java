package com.du.feheadstudio.controller;


import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.SimpleArticle;
import com.du.feheadstudio.pojo.ArticleSearchInfo;
import com.du.feheadstudio.pojo.ExchangeInfo;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Du425
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
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
        if ("0".equals(articleId)) {
            articleService.saveArticle(article);
        } else {
            articleService.updateArticle(article);
        }
        return CommonResult.ok();
    }

    /**
     * 获取所有文章 (简略)
     *
     * @param userId
     * @return
     */
    @GetMapping("/get/all/{userId}")
    public CommonResult getArticleList(@PathVariable String userId) {
        List<SimpleArticle> list = articleService.getArticleListByUserId(userId);

        return CommonResult.ok(list);
    }

    /**
     * 获取已存在的文章(详细)
     *
     * @param articleId
     * @return
     */
    @GetMapping("/get/{articleId}")
    public CommonResult getArticle(@PathVariable String articleId) {
        return CommonResult.ok(articleService.getArticleListByUserId(articleId));
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @DeleteMapping("/delete/{articleId}")
    public CommonResult deleteArticle(@PathVariable String articleId) {
        articleService.deleteArticle(articleId);
        return CommonResult.ok();
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

    @PostMapping("/exchange")
    public CommonResult exchange(@RequestBody ExchangeInfo info) {
        articleService.exchange(info.getOldSort(), info.getNewSort(), info.getUserId());
        return CommonResult.ok();
    }

}

