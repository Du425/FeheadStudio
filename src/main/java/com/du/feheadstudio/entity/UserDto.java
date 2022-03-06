package com.du.feheadstudio.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author DU425
 * @Date 2022/3/6 13:02
 * @Version 1.0
 * @Description todo 电话号码重复，密码邮箱格式校验未写
 */
@Data
@ApiModel(value = "User对象", description = "用于注册")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @ApiModelProperty("uuid随机生成")
    private String userId;

    @NotBlank(message = "电话号码不能为空")
    private String telephone;

    @NotBlank(message = "密码不能为空")
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    @NotBlank(message = "邮箱不能为空")
    private String email;
}
