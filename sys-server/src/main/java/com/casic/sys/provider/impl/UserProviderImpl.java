package com.casic.sys.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.mapper.UserMapper;
import com.casic.sys.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Service(interfaceClass = UserProvider.class)
@Component
public class UserProviderImpl implements UserProvider {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUser(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setId(UUID.randomUUID().toString());
        userMapper.insterUser(userEntity);
    }
}
