package com.du.feheadstudio.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Data
@ApiModel(value = "Article对象", description = "对应文章")
public class Article implements Serializable {

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
    private String coverImgId;
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

    @ApiModelProperty("0公开 1隐私")
    private Integer publishMethod;

    @ApiModelProperty("0已发布 1未发布")
    private Integer alreadyPublished;

    private LocalDateTime publishTime;

    private Integer viewNum;

    @ApiModelProperty("0true 1false，是否置顶")
    public Integer top;

}
