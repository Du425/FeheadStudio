package com.du.feheadstudio.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.feheadstudio.entity.Column;
import com.du.feheadstudio.entity.User;
import com.du.feheadstudio.mapper.ColumnMapper;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IColumnService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    ColumnMapper columnMapper;

    @Autowired
    IColumnService columnService;

    @PostMapping("/add")
    public CommonResult addColumn(@RequestBody Column column){
        if (columnService.saveOrUpdate(column)){
            String columnCoverId = column.getColumnCoverId();
            String columnName = column.getColumnName();
            return CommonResult.success("添加成功",column);
        }else {
            return CommonResult.failed("添加失败，请重新操作");
        }
    }

    @GetMapping("/get/all/{id}")
    public CommonResult getAll(@PathVariable("userId") String userId){
        List<Column> columnList = columnService.list(new QueryWrapper<Column>().eq("user_id",userId));
        if (columnList == null || columnList.size() < 1){
            return CommonResult.failed("获取失败");
        }else {
            for (Column column1 : columnList) {
                System.out.println(column1);
            }
            return CommonResult.success(columnList);
        }
    }

    @DeleteMapping("/delete")
    public CommonResult deleteColumn(Column column){
        if (columnMapper.deleteById(column) == 1){
            return CommonResult.success("删除成功");
        }else {
            return CommonResult.failed("操作失败，请重新删除");
        }
    }

    @PostMapping("/editor")
    public CommonResult editorColumn(@RequestBody Column column){
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



}

