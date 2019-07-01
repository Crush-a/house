package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.Type;
import com.kgc.house.entity.Type;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TypeService
 * @Description TODO
 * @Date 2019/6/18 8:30
 * @Created by Administrator
 */
public interface TypeService {

    //查询区域带分页
    PageInfo<Type> getTypeByPage(Integer page, Integer pageSize);

    /**
     * 添加区域
     * @param Type
     * @return
     */
    public int addType(Type type);


    /**
     * 修改区域
     * @param Type
     * @return
     */
    public int updateType(Type type);


    /**
     * 删除区域
     * @param 传id
     * @return
     */
    public int deleteType(Integer id);

    /**
     *
     * @param ids
     * @return
     */
    int deleteMoreType(Integer[] ids);

    /**
     * 查询所有类型
     * @return
     */
    List<Type> getAllType();
}
