package com.casic.sys.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.provider.UserProvider;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserProvider.class)
@Component
public class UserProviderImpl implements UserProvider {
    @Override
    public UserEntity getUser(String userId) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setUserName("admin");
        userEntity.setSex("男");
        return userEntity;
    }
}
