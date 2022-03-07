package com.du.feheadstudio.service;

import com.du.feheadstudio.pojo.Image;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/6 16:43
 */
public interface ImageService {
    /**
     * 保存图片到mongodb
     * @param image
     * @return
     */
     Boolean saveImage(Image image);

    /**
     *  从mongodb获取图片
     * @param id
     * @return
     */
     Image getImageById(String id);

    /**
     * 通过id删除图片
     * @param id
     * @return
     */
     Boolean deleteImageById(String id);
}
