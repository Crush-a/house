package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;

import java.util.List;

/**
 * @author 王建兵
 * @Classname DistrictService
 * @Description TODO
 * @Date 2019/6/18 8:30
 * @Created by Administrator
 */
public interface DistrictService {

    //查询区域带分页
    PageInfo<District> getDistrictByPage(Integer page, Integer pageSize);

    /**
     * 添加区域
     * @param district
     * @return
     */
    public int addDistrict(District district);


    /**
     * 修改区域
     * @param district
     * @return
     */
    public int updateDistrict(District district);


    /**
     * 删除区域
     * @param 传id
     * @return
     */
    public int deleteDistrict(Integer id);

    /**
     *
     * @param ids
     * @return
     */
    int deleteMoreDistrict(Integer[] ids);

    /**
     * 查询所有的区域
     * @return
     */
    List<District>  getAllDistrict();
}
