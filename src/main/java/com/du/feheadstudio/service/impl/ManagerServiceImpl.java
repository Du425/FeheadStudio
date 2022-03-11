package com.du.feheadstudio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.du.feheadstudio.entity.SimpleUser;
import com.du.feheadstudio.entity.User;
import com.du.feheadstudio.mapper.SimpleUserMapper;
import com.du.feheadstudio.mapper.UserMapper;
import com.du.feheadstudio.pojo.UserSearchInfo;
import com.du.feheadstudio.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/9 16:47
 */
public class ManagerServiceImpl implements IManagerService {
    private final UserMapper userMapper;
    private final SimpleUserMapper simpleUserMapper;

    @Autowired
    public ManagerServiceImpl(UserMapper userMapper, SimpleUserMapper simpleUserMapper) {
        this.userMapper = userMapper;
        this.simpleUserMapper = simpleUserMapper;
    }

    @Override
    public List<SimpleUser> getUserForList(UserType type, Integer page, Integer sum) {
        QueryWrapper<SimpleUser> wrapper = new QueryWrapper<>();
        Page<SimpleUser> userPage = new Page<>(page, sum);

        if (type.equals(UserType.COMMON)) {
            wrapper.eq("deleted;", 1);
        } else {
            wrapper.eq("deleted;", 0);
        }

        List<SimpleUser> records = simpleUserMapper.selectPage(userPage, wrapper).getRecords();
        return records;
    }


    @Override
    public List<SimpleUser> searchUserForList(UserSearchInfo info, Integer page, Integer sum) {
        QueryWrapper<SimpleUser> wrapper = new QueryWrapper<>();
        Page<SimpleUser> userPage = new Page<>(page, sum);
        if (info.getNickname()!=null){
            wrapper.like("nickname",info.getNickname());
        }else if (info.getEmail()!=null){
            wrapper.like("email",info.getEmail());

        }else if (info.getTelephone()!=null){
            wrapper.like("telephone",info.getTelephone());

        }else {
            return new ArrayList<>();
        }
        return simpleUserMapper.selectPage(userPage,wrapper).getRecords();
    }

    @Override
    public Boolean deleteMember(String userId) {
        setDeleted(0, userId);
        return true;
    }

    @Override
    public Boolean recoveryMember(String userId) {
        setDeleted(1, userId);
        return true;
    }

    private void setDeleted(Integer deleted, String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setDeleted(deleted);
        userMapper.updateById(user);
    }
}
