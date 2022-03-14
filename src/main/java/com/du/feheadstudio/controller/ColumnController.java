package com.du.feheadstudio.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.feheadstudio.entity.Columns;
import com.du.feheadstudio.mapper.ColumnsMapper;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/api/v1/column")
public class ColumnController {

    @Autowired
    ColumnsMapper columnMapper;

    @Autowired
    IColumnsService columnService;

    @PostMapping("/add")
    public CommonResult addColumn(@RequestBody Columns column) {
        if (columnMapper.insert(column) == 1) {
            return CommonResult.success("添加成功",column);
        } else {
            return CommonResult.failed("添加失败，请重新操作");
        }
    }

    @GetMapping("/get/all/{id}")
    public CommonResult getAll(@PathVariable("id") String userId){
        List<Columns> columnList = columnService.list(new QueryWrapper<Columns>().eq("user_id", userId));
        if (columnList == null || columnList.size() < 1) {
            return CommonResult.failed("获取失败");
        } else {
            for (Columns column1 : columnList) {
                System.out.println(column1);
            }
            return CommonResult.success(columnList);
        }
    }

    @DeleteMapping("/delete/{userId}/{columnId}")
    public CommonResult deleteColumn(@PathVariable String columnId, @PathVariable String userId){
        if (columnMapper.deleteById(columnId) == 1){
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("操作失败，请重新删除");
        }
    }

    @PostMapping("/editor")
    public CommonResult editorColumn(@RequestBody Columns column){
        if (columnMapper.updateById(column) == 1){
            return CommonResult.success("编辑成功",column);
        }else {
            return CommonResult.failed("编辑失败，请重新提交");
        }
    }

//    @PostMapping("/top")
//    public CommonResult topColumn(){
//
//    }

    @GetMapping("/search")
    public CommonResult searchColumn(@RequestBody Columns column) {
        QueryWrapper<Columns> wrapper = new QueryWrapper<>();
        wrapper.eq("columnName",column.getColumnName());
        if (columnMapper.selectOne(wrapper) != null){
            return CommonResult.success("查询成功",columnMapper.selectOne(wrapper));
        }
        else {
            return CommonResult.failed("查询失败");
        }
    }

    @PostMapping("/top")
    public CommonResult top(@RequestBody int oldSort,
                            @RequestBody int newSort,
                            @RequestBody String columnId){
        columnService.exchange(oldSort, newSort, columnId);
        Object o1 = new Object();

        return CommonResult.success("交换完成");

    }
}

