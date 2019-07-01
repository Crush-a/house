package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.UserCondition;
import com.kgc.house.entity.Users;
import com.kgc.house.entity.UsersExample;
import com.kgc.house.mapper.UsersMapper;
import com.kgc.house.service.UserService;
import com.kgc.house.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王建兵
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/6/21 9:25
 * @Created by Administrator
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUserByPage(UserCondition condition) {
        //查询所有
        PageHelper.startPage(condition.getPage(),condition.getRows());
        UsersExample usersExample=new UsersExample();
        //添加条件
        UsersExample.Criteria criteria=usersExample.createCriteria();
        criteria.andIsadminEqualTo(new Integer(1));  //表示管理员
        //添加查询条件
        //添加电话
        if(condition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        //添加开始年龄
        if(condition.getStartAge()!=null){
            criteria.andAgeGreaterThan(condition.getStartAge());
        }
        //添加结束年龄
        if(condition.getEndAge()!=null){
            criteria.andAgeLessThan(condition.getEndAge());
        }
        List<Users> list=usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int checkUname(String username) {
        //写持久化操作
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        //添加条件
        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(0);  //注册用户
        List<Users> users=usersMapper.selectByExample(usersExample);
        return users.size()==0?0:1;
    }

    @Override
    public int addUser(Users users) {
        //设置为前台注册用户
        users.setIsadmin(0);
        //对用户的密码使用MD5加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users login(String username, String password) {
        //SELECT * FROM users WHERE NAME='wjb' AND PASSWORD='202cb962ac59075b964b07152d234b70'
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        //添加条件
        criteria.andIsadminEqualTo(0);  //注册用户
        criteria.andNameEqualTo(username);
        //加密码
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

        List<Users> users=usersMapper.selectByExample(usersExample);
        if(users.size()==1){
            return users.get(0);
        }
        return null;
    }

}
