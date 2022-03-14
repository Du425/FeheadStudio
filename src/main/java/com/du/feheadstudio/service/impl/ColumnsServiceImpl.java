package com.du.feheadstudio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.feheadstudio.entity.Columns;
import com.du.feheadstudio.mapper.ColumnsMapper;
import com.du.feheadstudio.service.IColumnsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2022-03-06
 */
@Service
public class ColumnsServiceImpl extends ServiceImpl<ColumnsMapper, Columns> implements IColumnsService {

    @Autowired
    ColumnsMapper columnsMapper;

    @Override
    public boolean exchange(int a, int b, String columnId) {
        QueryWrapper<Columns> wrapper = new QueryWrapper<>();
        wrapper.eq("column_id", columnId);
        List<Columns> list = columnsMapper.selectList(wrapper);
        Columns columns = list.get(a);
        list.remove(a);
        list.add(b,columns);
        AtomicInteger atomicInteger = new AtomicInteger();
        list.forEach(l -> l.setSort(atomicInteger.getAndIncrement()) );
        return true;
    }
}
