package com.du.feheadstudio.pojo;

import lombok.Data;

/**
 * 搜索用户的条件
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/11 19:28
 */
@Data
public class UserSearchInfo {
    private String nickname;
    private String email;
    private String telephone;
    private Integer pages;
    private Integer onePageSum;
}
