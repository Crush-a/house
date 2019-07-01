package com.kgc.house.service.impl;

import com.kgc.house.entity.House;
import com.kgc.house.mapper.HouseMapper;
import com.kgc.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王建兵
 * @Classname HouseServiceImpl
 * @Description TODO
 * @Date 2019/6/24 16:05
 * @Created by Administrator
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }
}
