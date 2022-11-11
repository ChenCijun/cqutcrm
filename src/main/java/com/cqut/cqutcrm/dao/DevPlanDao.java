package com.cqut.cqutcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.cqutcrm.entity.DevPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //--框架创建对象
        //--BaseMapper<DecPlan>:单表查询的增加，删除，修改，查询
public interface DevPlanDao extends BaseMapper<DevPlan> {
    @Select("SELECT dp.dp_id , dp.dp_plandate , dp.dp_plancontent , dp.dp_execase , dp.dp_exedate ,\n" +
            " dp.dp_exemanager , dp.sc_id from sale_chance  sc , dev_plan dp\n" +
            "where sc.sc_id = dp.sc_id\n" +
            "and sc.sc_giveuser=#{giveuser}")
    public abstract List<DevPlan> queryPlan(String giveuser);
}
