package com.du.feheadstudio.pojo;

import com.du.feheadstudio.entity.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/13 21:03
 */
@Data
@NoArgsConstructor
public class ArticleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文章id
     */
    private String articleId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 正文
     */
    private String content;

    @ApiModelProperty("图片url")
    private String coverImgId = "localhost:8888/api/v1/image/onload/0";
    /**
     * 摘要
     */
    private String abstracts;
    /**
     * 标签
     */
    private List<String> label;
    /**
     * 专栏id
     */
    private List<String> columnId;

    @ApiModelProperty("0公开 1隐私")
    private Integer publishMethod;

    @ApiModelProperty("0已发布 1未发布")
    private Integer alreadyPublished;
    /**
     * LocalDateTime
     */
    private Long publishTime;

    private Integer viewNum = 0;

    public Integer top = 1;
    private Integer sort;

    public ArticleInfo(Article article) {

        this.articleId = article.getArticleId();
        this.userId = article.getUserId();
        this.top = article.getTop();
        this.sort = article.getSort();
        this.viewNum = article.getViewNum();
        this.publishTime = article.getPublishTime();
        this.alreadyPublished = article.getAlreadyPublished();
        this.publishMethod = article.getPublishMethod();
        this.columnId = Arrays.asList(article.getColumnId().split(","));
        this.coverImgId = article.getCoverImgId();
        String[] split = article.getLabel().split(",");
        this.label = Arrays.asList(split);
        this.title = article.getTitle();
        this.abstracts = article.getAbstracts();
        this.content = article.getContent();
    }
}
