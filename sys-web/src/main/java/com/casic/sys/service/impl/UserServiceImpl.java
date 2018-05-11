package com.casic.sys.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.provider.UserProvider;
import com.casic.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private UserProvider userProvider;

    @Override
    public UserEntity getUser(String userId) {
        logger.debug("用户编号："+userId);
        return userProvider.getUser(userId);
    }
}
