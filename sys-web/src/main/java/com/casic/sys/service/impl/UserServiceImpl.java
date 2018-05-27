package com.casic.sys.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.casic.core.base.service.impl.BaseServiceImpl;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.provider.UserProvider;
import com.casic.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserProvider,UserEntity>  implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private UserProvider userProvider;

    @PostConstruct
    public void init(){
        logger.debug("初始化执行++++");
        this.provider=userProvider;
    }

    @Override
    public String getUserName() {
        return null;
    }
}
