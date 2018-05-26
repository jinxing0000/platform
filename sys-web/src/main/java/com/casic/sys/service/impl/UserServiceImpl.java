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

@Service
public class UserServiceImpl extends BaseServiceImpl<UserProvider,UserEntity>  implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @DubboReference
//    private UserProvider userProvider;

    @Reference
    public void setProvider(UserProvider userProvider){
        this.provider = userProvider;
        logger.debug("执行赋值++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public String getUserName() {
        //provider = userProvider;
        logger.debug("执行赋值++++++++++++++++++++++++++++++++++++++++++");
        return null;
    }
}
