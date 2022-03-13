package com.du.feheadstudio.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2022-03-06
 */
@Data
@ApiModel(value = "Column对象", description = "")
public class Columns implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String columnId;

    @NotBlank
    private String columnName;

    private String columnCoverId;

    private Integer totalArticleNum;

    private Integer top;

    private String userId;

}
