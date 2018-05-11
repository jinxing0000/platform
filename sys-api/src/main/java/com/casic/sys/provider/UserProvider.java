package com.casic.sys.provider;

import com.casic.sys.entity.UserEntity;

public interface UserProvider {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    UserEntity getUser(String userId);

    /**
     * 保存用户信息
     * @param userEntity
     */
    void saveUser(UserEntity userEntity);
}
