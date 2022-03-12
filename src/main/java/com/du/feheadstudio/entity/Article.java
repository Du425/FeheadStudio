package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    private String coverImgId="localhost:8888/api/v1/image/onload/0";
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
    private String columnId;

    @ApiModelProperty("0公开 1隐私")
    private Integer publishMethod;

    @ApiModelProperty("0已发布 1未发布")
    private Integer alreadyPublished;
    /**
     * LocalDateTime
     */
    private Long publishTime;

    private Integer viewNum=0;

    @ApiModelProperty("0true 1false，是否置顶")
    public Integer top=1;
    private Integer sort;


}
