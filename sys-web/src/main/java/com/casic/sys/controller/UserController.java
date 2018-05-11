package com.casic.sys.controller;

import com.casic.sys.entity.UserEntity;
import com.casic.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController {
   @Autowired
   private UserService userService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public UserEntity getUser(@RequestParam Map<String, Object> params){
        String userId=(String)params.get("userId");
        return userService.getUser(userId);
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public void saveUser(@RequestBody UserEntity userEntity){
         userService.saveUser(userEntity);
    }
}
