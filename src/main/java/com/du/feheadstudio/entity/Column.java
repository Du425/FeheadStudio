package com.du.feheadstudio.entity;

import java.io.Serializable;
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

    private String columnId;

    private String columnName;

    private String columnCoverId;

    private Integer totalArticleNum;

    private Integer top;


}
