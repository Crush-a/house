package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Street;

import java.util.List;

/**
 * @author 王建兵
 * @Classname StreetService
 * @Description TODO
 * @Date 2019/6/21 11:31
 * @Created by Administrator
 */
public interface StreetService {

    //通过区域显示街道
    PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId);
    //通过区域显示街道
    List<Street> getStreetByDistrict(Integer districtId);

}
