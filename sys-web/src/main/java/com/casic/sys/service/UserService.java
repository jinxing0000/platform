package com.casic.sys.service;

import com.casic.core.base.service.BaseService;
import com.casic.sys.entity.UserEntity;

public interface UserService extends BaseService<UserEntity>{
    String getUserName();
}
