package com.kgc.house.test;

import com.kgc.house.entity.District;
import com.kgc.house.service.DistrictService;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        DistrictService service= (DistrictService)ctx.getBean("districtServiceImpl");
        PageInfo<District> pageInfo= service.getDistrictByPage(1,3);

        for (District d : pageInfo.getList()) {
            System.out.println(d.getName());
        }
        System.out.println(UUID.randomUUID());
    }
}
