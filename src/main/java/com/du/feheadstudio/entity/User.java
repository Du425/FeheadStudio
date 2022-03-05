package com.du.feheadstudio.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Data
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String nickName;

    private String telephone;

    private String password;

    private String email;

    private String headImgId;

    private String sex;

    private Date birthDate;

    @ApiModelProperty("个人简介")
    private String personalBrief;

    private LocalDateTime registerDate;

    @ApiModelProperty("数字代表角色")
    private Integer role;


}
