package com.du.feheadstudio.controller;

import com.du.feheadstudio.pojo.UserSearchInfo;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/9 16:39
 */
@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {
    private IManagerService managerService;

    @Autowired
    public ManagerController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/common")
    public CommonResult common(@RequestBody Integer pages,
                               @RequestBody Integer onePageSum) {
        return CommonResult.ok(managerService.getUserForList(IManagerService.UserType.COMMON,
                pages,
                onePageSum));
    }

    @PostMapping("/deleted")
    public CommonResult deleted(@RequestBody Integer pages,
                                @RequestBody Integer onePageSum) {
        return CommonResult.ok(managerService.getUserForList(IManagerService.UserType.DELETED,
                pages,
                onePageSum));
    }

    @PostMapping("/search")
    public CommonResult search(@RequestBody UserSearchInfo info,
                               @RequestBody Integer pages,
                               @RequestBody Integer onePageSum) {
        return CommonResult.ok(managerService.searchUserForList(info, pages, onePageSum));
    }

    @PostMapping("/delete_member/{userId}")
    public CommonResult deleteMember(@PathVariable String userId) {
        managerService.deleteMember(userId);
        return CommonResult.ok();
    }

    @PostMapping("/recovery_member/{userId}")
    public CommonResult recoveryMember(@PathVariable String userId) {
        managerService.recoveryMember(userId);
        return CommonResult.ok();
    }
}
