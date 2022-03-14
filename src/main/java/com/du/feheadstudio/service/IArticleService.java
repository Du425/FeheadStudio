package com.du.feheadstudio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.SimpleArticle;
import com.du.feheadstudio.pojo.ArticleSearchInfo;
import com.du.feheadstudio.pojo.TopArticleInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
public interface IArticleService extends IService<Article> {
    /**
     * 保存文章
     *
     * @param article
     * @return
     */
    Boolean saveArticle(Article article);

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    Boolean updateArticle(Article article);

    /**
     * 置顶文章
     * @param info
     * @return
     */
    Boolean topArticle(TopArticleInfo info);

    /**
     * 通过id删除存在的id
     *
     * @param articleId
     * @return
     */
    Boolean deleteArticle(String articleId);

    /**
     * 返回用户所有文章的简略信息
     *
     * @param userId
     * @return
     */
    List<SimpleArticle> getArticleListByUserId(String userId);

    /**
     * 返回id对应文章
     *
     * @param articleId
     * @return
     */
    Article getArticleById(String articleId);

    /**
     * 搜索文章 未分页
     * @param info
     * @return
     */
    public List<SimpleArticle> searchArticleList(ArticleSearchInfo info);

    /**
     * 插队
     * @param a
     * @param b
     * @param userId
     * @return
     */
    public  Boolean exchange(int a, int b,String userId);
}
