package com.du.feheadstudio.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author DU425
 * @Date 2022/3/6 13:02
 * @Version 1.0
 * @Description
 */
@Data
@ApiModel(value = "User对象", description = "用于注册")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("snowflake随机生成")
    private String userId;

    private String nickname;

    private String headImgId;

    private String sex;

    private Date birthDate;

    @ApiModelProperty("个人简介")
    private String personalBrief;

//    @NotBlank(message = "电话号码不能为空")
//    private String telephone;
//
//    @NotBlank(message = "密码不能为空")
//    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
//    private String password;
//
//    @NotBlank(message = "邮箱不能为空")
//    private String email;

}
