package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.UserCondition;
import com.kgc.house.entity.Users;

/**
 * @author 王建兵
 * @Classname UserService
 * @Description TODO
 * @Date 2019/6/21 9:24
 * @Created by Administrator
 */
public interface UserService {
    //查询所有用户
    PageInfo<Users> getUserByPage(UserCondition condition);

    //检查用户名是否存在
    public int checkUname(String username);

    //添加用户  注册
    public int addUser(Users users);

    //实现登入
    public Users login(String username, String password);

}
