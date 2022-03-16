package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.du.feheadstudio.pojo.ArticleInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Article对象", description = "对应文章")
public class Article implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 文章id
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    private String coverImgId="http://192.168.58.1:8888/api/v1/image/onload/0";
    /**
     * 摘要
     */
    private String abstracts;
    /**
     * 标签
     */
    private String label;
    /**
     * 专栏id
     */
    private String columnId;

    @ApiModelProperty("1公开 0隐私")
    private Integer publishMethod;

    @ApiModelProperty("1已发布 0发布")
    private Integer alreadyPublished;
    /**
     * LocalDateTime
     */
    private Long publishTime;

    private Integer viewNum = 0;

    @ApiModelProperty("0true 1false，是否置顶")
    public Integer top = 1;
    private Integer sort;

    public Article(ArticleInfo info) {

        this.articleId = info.getArticleId();
        this.userId=info.getUserId();
        this.top = info.getTop();
        this.sort = info.getSort();
        this.viewNum = info.getViewNum();
        this.publishTime = info.getPublishTime();
        this.alreadyPublished = info.getAlreadyPublished();
        this.publishMethod = info.getPublishMethod();
        StringBuilder builder = new StringBuilder();
        info.getColumnId().forEach(columnId->{
            builder.append(label);
            builder.append(',');
        });
        this.columnId = builder.toString();

        builder.setLength(0);
        this.coverImgId = info.getCoverImgId();
        info.getLabel().forEach(label->{
            builder.append(label);
            builder.append(',');
        });
        this.label= builder.toString();
        this.title = info.getTitle();
        this.abstracts = info.getAbstracts();
        this.content = info.getContent();
    }
}
