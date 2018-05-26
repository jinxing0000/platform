package com.casic.sys.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.casic.core.base.provider.impl.BaseProviderImpl;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.mapper.UserMapper;
import com.casic.sys.provider.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserProvider.class)
@Component
public class UserProviderImpl  extends BaseProviderImpl<UserMapper,UserEntity> implements UserProvider {
    @Autowired
    public void setMapper(UserMapper userMapper) {
        this.mapper=userMapper;
    }
}