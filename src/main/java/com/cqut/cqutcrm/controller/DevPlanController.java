package com.cqut.cqutcrm.controller;

import com.cqut.cqutcrm.entity.Customer;
import com.cqut.cqutcrm.entity.DevPlan;
import com.cqut.cqutcrm.entity.SaleChance;
import com.cqut.cqutcrm.entity.User;
import com.cqut.cqutcrm.service.CustomerService;
import com.cqut.cqutcrm.service.DevPlanService;
import com.cqut.cqutcrm.service.SaleChanceService;
import com.cqut.cqutcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域访问
@RequestMapping("sp")//设置请求路径
public class DevPlanController {
    @Autowired
    DevPlanService service;//自动装配
    //1.制定计划
    @RequestMapping("makeplan")
    public Map<String,Object> add(DevPlan devPlan){
        boolean flag = service.addplan(devPlan);
        Map<String,Object> map = new HashMap<>();
        map.put("msg",flag);
        return map;
    }
    //2.查询计划
    @RequestMapping("list")
    //--参数uname：表示当前登录的用户名，也就是销售机会中被分配人的名字
    public Map<String,Object> query(String uname){
        List<DevPlan> data = service.queryPlan(uname);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","");
        map.put("code",0);
        map.put("data",data);
        map.put("count",20);
        return map;
    }


    @Autowired
    SaleChanceService scService;
    @Autowired
    UserService userService;
    @Autowired
    CustomerService cusService;
    //3.执行计划
    @RequestMapping("exeplan")
    public Map<String,Object> exeplan(DevPlan devPlan, SaleChance saleChance){
        //--更新销售计划
        boolean flag = service.updateplan(devPlan);
        //--判断销售机会的状态为2，开发成功
        //--判断销售机会的状态为3，开发失败
        if(saleChance.getScStatus() == 2){
            scService.updateSc(saleChance);//更新销售机会状态
            //--创建客户（先根据销售机会id查询出销售机会，然后根据销售机会
            //查询出customer，如果customer查询不到说明没有这个客户，然后就查询当前用户的
            //uid ，最终创建客户（insert操作），否则不插入客户，）
            Customer customer = new Customer();
            SaleChance saleChance1 = scService.queryByScId(saleChance.getScId());
            if(saleChance1 != null){
//                customer.setCusName(saleChance1.getScCusname());
                Customer cus = cusService.findByCusname(saleChance1.getScCusname());
                if(cus != null){
                    User user = userService.findByUname(saleChance.getScGiveuser());
                    if(user !=null){
                        customer.setUserId(user.getuId());
                    }
                    customer.setCusName(saleChance1.getScCusname());
                    cusService.add(customer);
                }
            }
        }else if(saleChance.getScStatus() == 3){
            scService.updateSc(saleChance);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("msg",flag);
        return map;
    }
}
