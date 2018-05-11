package com.casic.sys.entity;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {
    private String id;
    private String userName;
    private String userSex;
    private String password;
}
