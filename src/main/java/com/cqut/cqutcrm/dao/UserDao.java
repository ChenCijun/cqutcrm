package com.cqut.cqutcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.cqutcrm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper//注解功能，让spring框架创建对象。
//BaseMapper中封装了基本的增加，删除，修改，查询等操作。
public interface UserDao extends BaseMapper<User> {

}
