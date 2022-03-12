package com.du.feheadstudio.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class Column implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String columnId;

    private String columnName;

    private String columnCoverId="http://192.168.52.1:8888/api/v1/image/onload/1";

    private Integer totalArticleNum;

    private Integer top;


}
