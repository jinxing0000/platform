package com.casic.sys.entity;

import com.casic.core.base.entity.BaseEntity;
import lombok.Data;

@Data
public class UserEntity extends BaseEntity {
    private String userName;
    private String userSex;
    private String password;
}
