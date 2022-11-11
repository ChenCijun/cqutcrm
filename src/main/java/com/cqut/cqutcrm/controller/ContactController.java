package com.cqut.cqutcrm.controller;

import com.cqut.cqutcrm.entity.Contact;
import com.cqut.cqutcrm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("contact")
public class ContactController {
    @Autowired
    ContactService contactService;
    //--1.添加联系人
    @RequestMapping("add")
    public Map<String,Object> add(Contact contact){
        Map<String,Object> map = new HashMap<>();
        boolean flag = contactService.addContact(contact);
        map.put("msg",flag);
        return map;
    }
    //--2.查询联系人
    @RequestMapping("list")
    public Map<String,Object> query(Integer cusId){
        Map<String,Object> map = new HashMap<>();
        List<Contact> contacts = contactService.queryByCusId(cusId);
        map.put("code",0);
        map.put("msg","");
        map.put("count",contacts.size());
        map.put("data",contacts);
        return map;
    }
    //--3.更新联系人信息
    @RequestMapping("update")
    public  Map<String,Object> update(Contact contact){
        Map<String,Object> map = new HashMap<>();
        boolean flag = contactService.updateContact(contact);;
        map.put("msg",flag);
        return map;
    }
    //--4.删除联系人信息
    @RequestMapping("del")
    public Map<String,Object> delete(Integer conId){
        Map<String,Object> map = new HashMap<>();
        boolean flag = contactService.deleteContact(conId);
        map.put("msg",flag);
        return map;
    }
}
