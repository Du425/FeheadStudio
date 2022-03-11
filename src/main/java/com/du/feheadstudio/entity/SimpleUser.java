package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/11 19:12
 */
@Data
@TableName("user")
public class SimpleUser implements Serializable{
    private LocalDateTime registerDate;
    private String nickname;
    private String email;
    private String telephone;
    private String role;

}
