package com.cqut.cqutcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.cqutcrm.entity.Customer;
import com.cqut.cqutcrm.entity.ReportEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerDao extends BaseMapper<Customer> {
    //--提供根据cus_level进行分组统计的方法
    @Select("select count(*) num,cus_level as item from" + " customer group by cus_level")
    public List<ReportEntity> selectCustomerCountByLevel();

    //--提供的是根据cus_region进行分组统计
    @Select("select count(*) num,cus_region as item from" + " customer group by cus_region")
    public List<ReportEntity> selectCustomerCountByRegion();
}
