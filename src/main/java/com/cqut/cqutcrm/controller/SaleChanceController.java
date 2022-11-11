package com.cqut.cqutcrm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqut.cqutcrm.entity.SaleChance;
import com.cqut.cqutcrm.service.SaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController//注解功能：1.表示这是Controller类型. 2.设置请求的返回值为json格式
@RequestMapping("sc")//注解的功能：内部方法的请求路径，都是sc的子路径
@CrossOrigin//允许跨越访问
public class SaleChanceController {
    @Autowired
    SaleChanceService service;

    @RequestMapping("list")//http://localhost:8080/sc/list?page=1&limit=5
    public Map<String,Object> query(Integer page,Integer limit){
        //前端界面需要的数据格式
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        IPage<SaleChance> onepage = service.getOnePage(page,limit);
        map.put("count",onepage.getTotal());//表的总行数
        map.put("data",onepage.getRecords());//当前页的数据
        return map;
    }

    @RequestMapping("add") //http://localhost:8080/sc/add
    public Map<String,Object> add(SaleChance sc){
        Map<String,Object> map = new HashMap<>();
        boolean flag = service.addSc(sc);
        map.put("msg",flag);
        return map;
    }
    @RequestMapping("del")
    public Map<String,Object> del(Integer scId){
        Map<String,Object> map = new HashMap<>();
        boolean flag =  service.deleteSc(scId);
        map.put("msg",flag);
        return map;
    }
    @RequestMapping("update")
    public Map<String,Object> update(SaleChance sc){
        Map<String,Object> map=new HashMap<>();
        boolean flag = service.updateSc(sc);
        map.put("msg",flag);
        return map;
    }

    @RequestMapping("give")
    public Map<String,Object> give(SaleChance sc){
        //---分配：分配后的销售机会状态为1，销售机会的分配时间
        sc.setScStatus(1);
        sc.setScGivetime(new Date());
        //---前端传入，分配给哪个客户经理，销售机会scId
        Map<String,Object> map = new HashMap<>();
        boolean flag = service.updateSc(sc);//根据主键更新
        map.put("msg",flag);
        return map;
    }

    @RequestMapping("mylist")//http://localhost:8080/sc/mylist?page=1&limit=5&uname=李经理
    public Map<String,Object> queryMy(Integer page,Integer limit,String uname){
        //前端界面需要的数据格式
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        IPage<SaleChance> onepage = service.getOnePageByGivename(page,limit,uname);
        map.put("count",onepage.getTotal());//表的总行数
        map.put("data",onepage.getRecords());//当前页的数据
        return map;
    }
}
