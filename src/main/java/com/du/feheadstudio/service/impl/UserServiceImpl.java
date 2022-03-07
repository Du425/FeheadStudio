package com.du.feheadstudio.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.feheadstudio.entity.User;
import com.du.feheadstudio.mapper.UserMapper;
import com.du.feheadstudio.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
