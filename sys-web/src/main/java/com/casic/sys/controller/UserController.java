package com.casic.sys.controller;

import com.casic.core.base.entity.PageEntity;
import com.casic.sys.entity.UserEntity;
import com.casic.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController {
   @Autowired
   private UserService userService;

    @RequestMapping(value = "getUserById", method = RequestMethod.GET)
    public UserEntity getUser(@RequestParam Map<String, Object> params){
        String id=(String)params.get("id");
        return userService.findById(id);
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public void saveUser(@RequestBody UserEntity userEntity){
        userService.getUserName();
        userService.saveEntity(userEntity);
    }

    @RequestMapping(value = "editUser", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    public UserEntity editUser(@RequestBody UserEntity userEntity){

        return userService.edit(userEntity);
    }

    @RequestMapping(value = "deleteUserById", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    public void deleteUserById(@RequestBody Map<String,Object> params){
         userService.delete(params);
    }

    @RequestMapping(value = "getUserByPage", method = RequestMethod.GET)
    public PageEntity<UserEntity> getUserByPage(@RequestParam Map<String, Object> params){
       return userService.findListByPage(params);
    }

    @RequestMapping(value = "getUserByList", method = RequestMethod.GET)
    public List<UserEntity> getUserByList(@RequestParam Map<String, Object> params){
        return userService.findList(params);
    }

    @RequestMapping(value = "saveBathUser", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public void saveBathUser(@RequestBody List<UserEntity> userEntityList){
        userService.saveBatch(userEntityList);
    }

    @RequestMapping(value = "editBathUser", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    public void editBathUser(@RequestBody List<UserEntity> userEntityList){
        userService.editBatch(userEntityList);
    }

    @RequestMapping(value = "deleteBathUser", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    public void deleteBathUser(@RequestBody List<UserEntity> userEntityList){
        userService.deleteBatch(userEntityList);
    }

}
