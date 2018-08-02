package com.ljheee.tk.controller;

import com.ljheee.tk.entity.UserInfo;
import com.ljheee.tk.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lijianhua04 on 2018/8/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserInfoMapper userInfoMapper;



    @GetMapping("/all")
    public List<UserInfo> getUserMapper() {
        return userInfoMapper.selectAll();
    }


    @GetMapping("/list")
    public List<UserInfo> list(){
        Example example = new Example(UserInfo.class);
        example.createCriteria().andGreaterThan("id","0");
        return userInfoMapper.selectByExample(example);
    }

}
