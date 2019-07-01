package com.kgc.house.protal.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;
import com.kgc.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname UsersController
 * @Description TODO
 * @Date 2019/6/21 9:29
 * @Created by Administrator
 */
@Controller("steetController2")
@RequestMapping("/page/")
public class SteetController {
     @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByDid2")
    @ResponseBody
    public List<Street> getStreetByDid2(Integer did){
        //调用业务
       return streetService.getStreetByDistrict(did);
    }

}
