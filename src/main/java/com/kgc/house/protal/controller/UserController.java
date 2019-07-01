package com.kgc.house.protal.controller;

import com.kgc.house.entity.Users;
import com.kgc.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 王建兵
 * @Classname UserController
 * @Description TODO
 * @Date 2019/6/22 9:15
 * @Created by Administrator
 */
@Controller
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("checkUname")
    @ResponseBody
    public String checkUname(String username){
       //调用业务
        int temp=userService.checkUname(username);
        return "{\"result\":"+temp+"}";  //返回json
    }


    @RequestMapping("regUser")
    public String regUser(Users users){
        //调用业务
        int temp=userService.addUser(users);
        if(temp>0)
        return "login";
        else
            return "error";
    }


    @RequestMapping("login")
    public String regUser(String username, String password, Model model,  HttpSession session){
        //调用业务
        Users user=userService.login(username,password);
        if(user==null) {
            model.addAttribute("info","用户名密码错误!");
            return "login";  //继续登入
        }
        else {
            //只要登入:使用session或者cookie保存登入的信息
           session.setAttribute("user",user);
           session.setMaxInactiveInterval(600); //30秒
           return "guanli";  //用户中心的管理页
        }
    }
}
