package com.cqut.cqutcrm.controller;

import com.cqut.cqutcrm.entity.ReportEntity;
import com.cqut.cqutcrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("report")
@CrossOrigin
public class ReportController {
    @Autowired
    private CustomerService service;

    @RequestMapping("customerCountByLevel")
    public Map<String,Object> customerCountByLevel(){
        List<ReportEntity> list = service.getCustomerCountByLevel();
        List<String> category = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for(ReportEntity re:list){
            data.add(re.getNum());
            //把查询结果中的item，转换为用户需要看的字符串
            switch (re.getItem()){
                case "A":
                    category.add("重点客户");
                    break;
                case "B":
                    category.add("普通客户");
                    break;
                case "C":
                    category.add("非优先客户");
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("data",data);
        map.put("category",category);
        return map;
    }

    @RequestMapping("customerCountByRegion")
    public Map<String,Object> customerCountByRegion(){
        Map<String,Object> ret = new HashMap<>();
        List<ReportEntity> list = service.getCustomerCountByRegion();
        //循环返回的报单实体，取出等级放入一个列表，取出客户数量放入另一个列表
        List<String> categoryList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        for(ReportEntity re:list){
            switch (re.getItem()){
                case "1":
                    re.setItem("东北");
                    break;
                case "2":
                    re.setItem("华北");
                    break;
                case "3":
                    re.setItem("西北");
                    break;
                case "4":
                    re.setItem("西南");
                    break;
                case "5":
                    re.setItem("华南");
                    break;
                case "6":
                    re.setItem("华中");
                    break;
                case "7":
                    re.setItem("华东");
                    break;
            }
            categoryList.add(re.getItem());
            dataList.add(re.getNum());
        }
        ret.put("category",categoryList);
        ret.put("data",dataList);
        return ret;
    }
}
