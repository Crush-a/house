package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.entity.Type;
import com.kgc.house.service.DistrictService;
import com.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname DistrictController
 * @Description TODO
 * @Date 2019/6/18 8:54
 * @Created by Administrator
 */
@Controller
@RequestMapping("/admin/")
public class TypeController {

    @Autowired
    private TypeService typeService;

     @RequestMapping("getType")
     @ResponseBody
     public Map<String,Object> getType(Integer page,Integer rows){
       //调用业务
        PageInfo<Type> pageInfo=typeService.getTypeByPage(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
     }



    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type type){
        //调用业务
        int temp=typeService.addType(type);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("upType")
    @ResponseBody
    public String upType(Type type){
        //调用业务
        int temp=typeService.updateType(type);
        return "{\"result\":"+temp+"}";
    }


    @RequestMapping("delType")
    @ResponseBody
    public String delType(Integer id){
        //调用业务
        int temp=typeService.deleteType(id);
        return "{\"result\":"+temp+"}";
    }


    /**
     * 批量删除的控制器
     */
    @RequestMapping("delMoreType")
    @ResponseBody
    public String delDistrict(String ids){  // ids=1,2,3,4
        //将字符串转化为整型数组
        String [] arys=ids.split(",");
        Integer [] id=new Integer[arys.length];
        for (int i=0;i<arys.length;i++){
            id[i]=Integer.parseInt(arys[i]);
        }
        //调用业务
        int temp=typeService.deleteMoreType(id);
        return "{\"result\":"+temp+"}";
    }

}
