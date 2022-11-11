package com.cqut.cqutcrm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.cqutcrm.dao.CustomerDao;
import com.cqut.cqutcrm.entity.Customer;
import com.cqut.cqutcrm.entity.ReportEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;
    //--1.添加客户
    public Boolean add(Customer customer){
        int row = customerDao.insert(customer);
        return row > 0 ? true : false;
    }

    //--2.根据客户的名字，查询客户
    public Customer findByCusname(String cusname){
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cus_name",cusname);
        List<Customer> customers = customerDao.selectList(queryWrapper);
        if(customers != null && customers.size()>0){
            return customers.get(0);
        }
        return null;
    }

    //--3.分页查询客户（只查询当前登录用户的客户）
    public IPage<Customer> getOnePageByUname(Integer page,Integer row,String uid){
        IPage<Customer> iPage = new Page<>(page,row);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_id",uid);
        iPage = customerDao.selectPage(iPage,queryWrapper);
        return iPage;
    }

    //--4.修改客户信息
    public Boolean updateCustomer(Customer customer){
        int row = customerDao.updateById(customer);
        return row > 0 ? true : false;
    }

    //--5.删除客户信息
    public Boolean deleteCustomer(Integer cusId){
        int row = customerDao.deleteById(cusId);
        return row > 0 ? true : false;
    }

    //--统计客户的等级情况
    public List<ReportEntity> getCustomerCountByLevel(){
        return customerDao.selectCustomerCountByLevel();
    }

    //---统计客户的地区分布
    public List<ReportEntity> getCustomerCountByRegion(){
        return customerDao.selectCustomerCountByRegion();
    }
}
