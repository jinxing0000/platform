package com.casic.sys.provider;

import com.casic.sys.entity.UserEntity;

public interface UserProvider {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    UserEntity getUser(String userId);
}
