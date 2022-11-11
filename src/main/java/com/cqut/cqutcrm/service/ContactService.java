package com.cqut.cqutcrm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqut.cqutcrm.dao.ContactDao;
import com.cqut.cqutcrm.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactDao contactDao;
    //--1.添加联系人
    public Boolean  addContact(Contact contact){
        int row =  contactDao.insert(contact);
        return row > 0 ? true : false;
    }

    //--2.更新联系人
    public Boolean updateContact(Contact contact){
        int row = contactDao.updateById(contact);
        return row > 0 ? true : false;
    }

    //--3.删除联系人
    public Boolean deleteContact(Integer conId){
        int row = contactDao.deleteById(conId);
        return row > 0 ? true : false;
    }

    //--4.查询联系人
    public List<Contact> queryByCusId(Integer cusId){
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("cus_id",cusId);
        return contactDao.selectList(queryWrapper);
    }
}
