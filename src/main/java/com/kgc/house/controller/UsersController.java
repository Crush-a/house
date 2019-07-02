package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.UserCondition;
import com.kgc.house.entity.Users;
import com.kgc.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname UsersController
 * @Description TODO
 * @Date 2019/6/21 9:29
 * @Created by Administrator
 */
@Controller
@RequestMapping("/admin/")
public class UsersController {

     @Autowired
    private UserService userService;


    @RequestMapping("getUsers")
    @ResponseBody
    public Map<String,Object> getUsers(UserCondition condition){
        //调用业务
        PageInfo<Users> pageInfo=userService.getUserByPage(condition);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }




}
