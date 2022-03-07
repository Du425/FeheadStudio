package com.du.feheadstudio.service.impl;

import com.du.feheadstudio.pojo.Image;
import com.du.feheadstudio.service.ImageService;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/6 16:43
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    private MongoTemplate template;
    final static String COLLECTION_NAME = "image";

    public ImageServiceImpl(MongoTemplate mongoTemplate) {
        this.template = mongoTemplate;
    }

    /**
     * 保存图片
     *
     * @param image
     * @return
     */
    @Override
    public Boolean saveImage(Image image) {
        template.save(image, COLLECTION_NAME);
        if ("".equals(image.getId()) || image.getId() == null) {
            log.error("图像保存失败");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检索图片
     */
    @Override
    public Image getImageById(String id) {
      return template.findOne(new Query(Criteria.where("id").is(id)), Image.class, COLLECTION_NAME);

    }

    @Override
    public Boolean deleteImageById(String id) {
        DeleteResult remove = template.remove(new Query(Criteria.where("id").is(id)));
        return remove.getDeletedCount()>0;
    }
}
