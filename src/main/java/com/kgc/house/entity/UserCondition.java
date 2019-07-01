package com.kgc.house.entity;

/**
 * @author 王建兵
 * @Classname UserCondition
 * @Description TODO
 * @Date 2019/6/21 9:51
 * @Created by Administrator
 */
public class UserCondition {
    //分页
    private Integer page;  //页码
    private Integer rows;  //页大小

    //条件属性
    private String telephone;  //电话
    private Integer startAge;  //开始年龄
    private  Integer endAge;  //结束年龄

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }
}
