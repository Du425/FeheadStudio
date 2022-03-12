package com.du.feheadstudio.service;

import com.du.feheadstudio.entity.SimpleUser;
import com.du.feheadstudio.pojo.UserSearchInfo;

import java.util.List;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/9 16:47
 */
public interface IManagerService {
    /**
     * 表示需要的类型
     */
    enum UserType {
        /**
         * 正常的
         */
        COMMON,
        /**
         * 已经删除的
         */
        DELETED;
    }

    /**
     * 获取用户列表
     *
     * @param type 类型
     * @param page
     * @param sum
     * @return List<SimpleUser>
     */
    List<SimpleUser> getUserForList(UserType type, Integer page, Integer sum);

    /**
     * 通过条件返回满足条件的用户
     *
     * @param info
     * @param page
     * @param sum
     * @return
     */
    List<SimpleUser> searchUserForList(UserSearchInfo info, Integer page, Integer sum);

    /**
     * 删除正常成员
     *
     * @param userId
     * @return
     */
    Boolean deleteMember(String userId);

    /**
     * 恢复已删除成员
     *
     * @param userId
     * @return
     */
    Boolean recoveryMember(String userId);
}
