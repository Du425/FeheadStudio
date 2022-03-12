package com.du.feheadstudio.pojo;

import lombok.Data;

/**
 * 保存图片对应类
 * @author wrobby
 * @version 1.0
 * @date 2022/3/6 16:39
 */
@Data
public class Image  {
    private String id;
    private byte[] file;
}
