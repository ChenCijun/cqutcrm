package com.cqut.cqutcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.cqutcrm.entity.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactDao extends BaseMapper<Contact> {
}
