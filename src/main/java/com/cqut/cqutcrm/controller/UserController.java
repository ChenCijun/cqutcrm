package com.cqut.cqutcrm.controller;

import com.cqut.cqutcrm.entity.User;
import com.cqut.cqutcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//设置类的类型是controller,并且请求的返回值设置为json

@CrossOrigin
public class UserController {
    @Autowired
    UserService service;
    //1.登录的请求
    @RequestMapping("login") // http://localhost:8080/login
    public Map<String,Object> login(User user){
        // -- 请求参数的名字，和实体类User的属性名一致，框架就会把请求参数封装到user对象中
        User user1 = service.findByUnameAndUPassword(user);
        Map<String,Object> map = new HashMap<>();
        if (user1 == null){
            map.put("msg",false);
        }else {
            map.put("msg",true);
            user1.setuPassword("");
            map.put("user",user1);
        }
        return map;
    }
    //2.查询所有的客户经理
    @RequestMapping("managers")
    public List<User> findManager(){
        List<User> managers= service.findByRid();
        return managers;
    }
}
