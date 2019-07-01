package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.entity.DistrictExample;
import com.kgc.house.entity.Type;
import com.kgc.house.entity.TypeExample;
import com.kgc.house.mapper.TypeMapper;
import com.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TypeServiceImpl
 * @Description TODO
 * @Date 2019/6/21 8:32
 * @Created by Administrator
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper  typeMapper;

    @Override
    public PageInfo<Type> getTypeByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        //调用dao层查询   一定查询所有
        //1.定义持久化操作查询所有
        //2.使用selectByExample查询(带条件查询非常有用)
        //1.创建条件实体
        TypeExample example=new TypeExample();
        //2.获得criteria对象添加条件
        //DistrictExample.Criteria criteria=example.createCriteria();
        //criteria.andNameLike("%东%");

        List<Type> list=typeMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteMoreType(Integer[] ids) {
        return typeMapper.deleteMoreType(ids);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
