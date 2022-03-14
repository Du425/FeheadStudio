package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String userId;

    private String nickname;

    //todo 格式规范没有起作用
    @Size(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String telephone;

    @Size(min = 6, max = 30, message = "密码长度应当在 6 ~ 30 个字符之间")
    private String password;

    @Email(message = "错误的邮件格式")
    private String email;

    private String headImgId;

    private String sex;

    private Date birthDate;

    @ApiModelProperty("个人简介")
    private String personalBrief;

    private LocalDateTime registerDate;

    @ApiModelProperty("数字代表角色")
    private Integer role;

    @ApiModelProperty("是否被删除")
    private Integer deleted;

    private Integer articleNum;

}
