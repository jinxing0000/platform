package com.casic.sys.service;

import com.casic.sys.entity.UserEntity;

public interface UserService {
    UserEntity getUser(String userId);

    void saveUser(UserEntity userEntity);
}
