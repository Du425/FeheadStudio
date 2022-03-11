package com.du.feheadstudio.mapper;

import com.du.feheadstudio.response.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/9 16:39
 */
@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {
    @GetMapping("/common")
    public CommonResult common(){
        return null;
    }
    @GetMapping("/deleted")
    public CommonResult deleted(){
        return null;
    }
    @PostMapping("/search")
    public CommonResult search (){
        return null;
    }
    @PostMapping("/delete_member/{userId}")
    public CommonResult deleteMember(@PathVariable String userId){
        return null;
    }
    @PostMapping("/recovery_member/{userId}")
    public CommonResult recoveryMember(@PathVariable String userId){
        return null;
    }
}
