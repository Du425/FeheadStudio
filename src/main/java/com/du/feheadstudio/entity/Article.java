package com.du.FeheadStudio.entity;

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
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String articleId;

    private String userId;

    private String title;

    private String content;

    @ApiModelProperty("图片url")
    private String cover;

    private String abstracts;

    private String label;

    private String columnId;

    private Integer publishMethod;

    private Integer isPublished;

    private LocalDateTime publishTime;

    private Integer viewNum;

}
