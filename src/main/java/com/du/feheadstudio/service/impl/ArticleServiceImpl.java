package com.du.feheadstudio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.BriefArticle;
import com.du.feheadstudio.mapper.ArticleMapper;
import com.du.feheadstudio.mapper.BriefArticleMapper;
import com.du.feheadstudio.service.IArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    private ArticleMapper articleMapper;
    private BriefArticleMapper briefArticleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper, BriefArticleMapper briefArticleMapper) {
        this.articleMapper = articleMapper;
        this.briefArticleMapper = briefArticleMapper;
    }

    @Override
    public Boolean saveArticle(Article article) {
        //插入文章
        int insert = articleMapper.insert(article);
        //插入简略信息
        LocalDateTime publishTime = article.getPublishTime();
        BriefArticle briefArticle = new BriefArticle(publishTime.getYear(),
                publishTime.getMonthValue(),
                article.getColumnId(),
                article.getTitle()
        );
        int insertBrief = briefArticleMapper.insert(briefArticle);
        return insert > 0 && insertBrief > 0;
    }

    @Override
    public Boolean updateArticle(Article article) {
        return null;
    }

    @Override
    public Boolean deleteArticle(String articleId) {

        int delete1 = briefArticleMapper.deleteById(articleId);
        int delete2 = articleMapper.deleteById(articleId);
        return delete1>0&&delete2>0;
    }

    @Override
    public List<BriefArticle> getArticleListByUserId(String userId) {
        QueryWrapper<BriefArticle> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("",userId);
        return briefArticleMapper.selectList(queryWrapper);
    }

    @Override
    public Article getArticleById(String articleId) {
        return null;
    }
}
