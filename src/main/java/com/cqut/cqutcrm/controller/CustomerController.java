package com.cqut.cqutcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqut.cqutcrm.dao.CustomerDao;
import com.cqut.cqutcrm.entity.Customer;
import com.cqut.cqutcrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;
    //--1.添加客户
    @RequestMapping("add")
    public Map<String,Object> add(Customer customer,Integer uid){
        Customer byCusname = customerService.findByCusname(customer.getCusName());
        Map<String,Object> map = new HashMap<>();
        if(byCusname == null) {//没有重复名字，插入客户信息得到数据库
            customer.setUserId(uid);
            Boolean flag = customerService.add(customer);
            map.put("msg",flag);
        }else {
            map.put("msg",false);
        }
        return map;
    }
    //--2.查询客户
    @RequestMapping("list")
    public Map<String,Object> query(Integer page,Integer limit,String uid){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        IPage<Customer> customerIPage = customerService.getOnePageByUname(page,limit,uid);
        map.put("count",customerIPage.getTotal());
        map.put("data",customerIPage.getRecords());
        return map;
    }

    //--3.修改客户
    @RequestMapping("update")
    public Map<String,Object> update(Customer customer){
        Map<String,Object> map = new HashMap<>();
        boolean flag = customerService.updateCustomer(customer);
        map.put("msg",flag);
        return map;
    }

    //--4.删除客户
    @RequestMapping("del")
    public Map<String,Object> delete(Integer cusId){
        Map<String,Object> map = new HashMap<>();
        boolean flag = customerService.deleteCustomer(cusId);
        map.put("msg",flag);
        return map;
    }

}
