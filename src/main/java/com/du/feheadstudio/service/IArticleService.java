package com.du.feheadstudio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.BriefArticle;

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
    List<BriefArticle> getArticleListByUserId(String userId);

    /**
     * 返回id对应文章
     *
     * @param articleId
     * @return
     */
    Article getArticleById(String articleId);
}
