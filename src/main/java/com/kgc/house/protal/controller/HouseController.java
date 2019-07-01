package com.kgc.house.protal.controller;

import com.kgc.house.entity.District;
import com.kgc.house.entity.House;
import com.kgc.house.entity.Type;
import com.kgc.house.entity.Users;
import com.kgc.house.service.DistrictService;
import com.kgc.house.service.HouseService;
import com.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author 王建兵
 * @Classname HouseController
 * @Description TODO
 * @Date 2019/6/24 13:50
 * @Created by Administrator
 */
@Controller
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private HouseService houseService;


    @RequestMapping("goFaBu")
    public String goFaBu(Model model) throws  Exception{
        //查询所有类型
        List<Type> types=typeService.getAllType();
        //查询所有域名域
        List<District> Districts=districtService.getAllDistrict();

        //使用model将数据传递到页面
        model.addAttribute("types",types);
        model.addAttribute("districts",Districts);
        return "fabu";  //跳转页面
    }


    @RequestMapping("addHouse")
    public String addHouse(House house, @RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws  Exception{
        //将文件保存在服务器中  D:\\images

        String fname=pfile.getOriginalFilename();
        String expName=fname.substring(fname.lastIndexOf("."));
        String saveName=System.currentTimeMillis()+expName; //保存文件名
        File file=new File("D:\\images\\"+saveName);
        pfile.transferTo(file);  //保存


        //保存数据库的记录  house已经接收部分表单数据
        //设置编号
        house.setId(System.currentTimeMillis()+"");
        //设置用户编号
        Users user=(Users)session.getAttribute("user");
        house.setUserId(user.getId());
        //设置审核状态 0  如果表中有默认值 可不设
        house.setIspass(0);
        //设置是否删除  0
        house.setIsdel(0);
        //设置图片路径
        house.setPath(saveName);

        if(houseService.addHouse(house)>0){ //保存数据
            //调用业务
            //houseService.addHouse(house); //添加信息到数据库
            return "redirect:goFaBu";  //跳转页面
        }
        else{
             //成功上传的图片删除
            file.delete();
            return "redirect:goFaBu";  //跳转页面
        }

    }
}
