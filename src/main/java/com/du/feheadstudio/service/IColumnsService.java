package com.du.feheadstudio.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.du.feheadstudio.entity.Columns;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Du425
 * @since 2022-03-06
 */

public interface IColumnsService extends IService<Columns> {

    boolean exchange(int a, int b, String columnId);

    boolean saveColumns(Columns columns);

}
