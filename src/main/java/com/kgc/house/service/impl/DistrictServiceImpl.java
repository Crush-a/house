package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.entity.District;
import com.kgc.house.entity.DistrictExample;
import com.kgc.house.mapper.DistrictMapper;
import com.kgc.house.mapper.StreetMapper;
import com.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**


 */
@Service
public class DistrictServiceImpl implements DistrictService
{
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getDistrictByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        //调用dao层查询   一定查询所有
        //1.定义持久化操作查询所有
        //2.使用selectByExample查询(带条件查询非常有用)
        //1.创建条件实体
        DistrictExample example=new DistrictExample();
        //2.获得criteria对象添加条件
        //DistrictExample.Criteria criteria=example.createCriteria();
        //criteria.andNameLike("%东%");

        List<District> list=districtMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Transactional
    public int deleteDistrict(Integer id) {
        try {
            //删除街道   通过区域删除街道
            streetMapper.deleltStreetByDid(id);
            //删除区域
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteMoreDistrict(Integer[] ids) {
        return districtMapper.deleteMoreDistrict(ids);
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
