package com.casic.sys.mapper;

import com.casic.sys.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insterUser(UserEntity userEntity);

    UserEntity selectUser(String id);
}
