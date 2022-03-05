package com.du.feheadstudio.service.impl;

import com.du.feheadstudio.entity.Article;
import com.du.feheadstudio.mapper.ArticleMapper;
import com.du.feheadstudio.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
