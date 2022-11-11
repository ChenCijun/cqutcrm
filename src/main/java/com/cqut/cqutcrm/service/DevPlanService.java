package com.cqut.cqutcrm.service;

import com.cqut.cqutcrm.dao.DevPlanDao;
import com.cqut.cqutcrm.entity.DevPlan;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DevPlanService {
    @Autowired
    DevPlanDao devPlanDao;

    //1.指定计划（insert）
    public Boolean addplan(DevPlan devPlan){
        int row = devPlanDao.insert(devPlan);
        return row > 0 ? true : false;
    }

    //2.执行计划（根据主键更新的操作）
    public Boolean updateplan(DevPlan devPlan){
        int row = devPlanDao.updateById(devPlan);
        return row > 0 ? true : false;
    }

    //3.查询出当前登录用户的销售计划(select)
    public List<DevPlan> queryPlan(String uname){
        return devPlanDao.queryPlan(uname);
    }
}
