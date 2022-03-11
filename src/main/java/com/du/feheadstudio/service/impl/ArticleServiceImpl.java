package com.du.feheadstudio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.entity.ArticleJumpLine;
import com.du.feheadstudio.entity.BriefArticle;
import com.du.feheadstudio.mapper.ArticleJumpLineMapper;
import com.du.feheadstudio.mapper.ArticleMapper;
import com.du.feheadstudio.mapper.BriefArticleMapper;
import com.du.feheadstudio.entity.SimpleArticle;
import com.du.feheadstudio.mapper.SimpleArticleMapper;
import com.du.feheadstudio.pojo.ArticleSearchInfo;
import com.du.feheadstudio.service.IArticleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    private final ArticleMapper articleMapper;
    private final BriefArticleMapper briefArticleMapper;
    private final SimpleArticleMapper simpleArticleMapper;
    private final ArticleJumpLineMapper articleJumpLineMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper, BriefArticleMapper briefArticleMapper,
                              SimpleArticleMapper simpleArticleMapper, ArticleJumpLineMapper articleJumpLineMapper) {
        this.articleMapper = articleMapper;
        this.briefArticleMapper = briefArticleMapper;
        this.simpleArticleMapper = simpleArticleMapper;
        this.articleJumpLineMapper = articleJumpLineMapper;
    }

    /**
     * 保存文章
     *
     * @param article 文章
     * @return 是否成功
     */
    @Override
    public Boolean saveArticle(Article article) {
        //设置sort
        article.setSort(1);
        //插入文章
        int insert = articleMapper.insert(article);
        //插入简略信息
        Long publishTime = article.getPublishTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(publishTime);
        BriefArticle briefArticle = new BriefArticle(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                article.getColumnId(),
                article.getTitle()
        );
        int insertBrief = briefArticleMapper.insert(briefArticle);
        return insert > 0 && insertBrief > 0;
    }

    @Override
    public Boolean updateArticle(Article article) {
        int update = articleMapper.updateById(article);
        //更新搜索用简略信息
        Long publishTime = article.getPublishTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(publishTime);
        BriefArticle briefArticle = new BriefArticle(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                article.getColumnId(),
                article.getTitle()
        );
        briefArticleMapper.updateById(briefArticle);
        return update > 0;
    }

    @Override
    public Boolean deleteArticle(String articleId) {
        int delete1 = briefArticleMapper.deleteById(articleId);
        int delete2 = articleMapper.deleteById(articleId);
        //用户文章数减1


        return delete1 > 0 && delete2 > 0;
    }

    @Override
    public List<SimpleArticle> getArticleListByUserId(String userId) {
        QueryWrapper<SimpleArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return simpleArticleMapper.selectList(queryWrapper);
    }
    @Override
    public Article getArticleById(String articleId) {
        return articleMapper.selectById(articleId);
    }

    @Override
    public List<SimpleArticle> searchArticleList(ArticleSearchInfo info) {
        QueryWrapper<SimpleArticle> queryWrapper = new QueryWrapper<>();
        if (info.getYear() != null) {
            queryWrapper.eq("year", info.getYear());
        } else if (info.getMonth() != null) {
            queryWrapper.eq("month", info.getMonth());
        } else if (info.getColumnName() != null) {
            queryWrapper.eq("column_name", info.getColumnName());
        } else if (info.getTitleAbstruct() != null) {
            queryWrapper.like("title", info.getTitleAbstruct());
        } else {
            return new ArrayList<>();
        }
        queryWrapper.eq("user_id", info.getUserId());

        return simpleArticleMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean exchange(int a, int b, String userId) {
        QueryWrapper<ArticleJumpLine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<ArticleJumpLine> list = articleJumpLineMapper.selectList(queryWrapper);
        ArticleJumpLine simpleArticle = list.get(a);
        list.remove(a);
        list.add(b, simpleArticle);
        AtomicInteger size = new AtomicInteger();
        list.forEach(l -> l.setSort(size.getAndIncrement()));
        return true;
    }
}
