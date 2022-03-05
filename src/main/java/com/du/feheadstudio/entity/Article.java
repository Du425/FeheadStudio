package com.du.feheadstudio.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Data
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String articleId;

    private String userId;

    private String title;

    private String content;

    @ApiModelProperty("图片url")
    private String coverImgId;

    private String abstracts;

    private String label;

    private String columnId;

    @ApiModelProperty("0公开 1隐私")
    private Integer publishMethod;

    @ApiModelProperty("0已发布 1未发布")
    private Integer published;

    private LocalDateTime publishTime;

    private Integer viewNum;

    @ApiModelProperty("0true 1false，是否置顶")
    public Integer top;

}
