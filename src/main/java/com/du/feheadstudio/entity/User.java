package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
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

    @ApiModelProperty("是否被删除")
    private Integer deleted;
    private Integer articleNum;

}
