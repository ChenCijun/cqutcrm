package com.cqut.cqutcrm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqut.cqutcrm.dao.UserDao;
import com.cqut.cqutcrm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service//注解功能：spring框架创建对象
public class UserService {
    @Autowired//自动装配
    UserDao userDao;

    //1.定义一个根据用户名和密码进行查询user的方法
    public User findByUnameAndUPassword(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_name",user.getuName());
        queryWrapper.eq("u_password",user.getuPassword());
        List<User> users = userDao.selectList(queryWrapper);
        //--判断是否查到了数据
        if(users!=null && users.size()>0){
            return users.get(0);
        }
        return null;
    }
    //2.查询所有的客户经理的信息（rid=2就是客户经理）
    public List<User> findByRid(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("r_id",2);
        return userDao.selectList(queryWrapper);
    }

    //3.根据用户的名字，查询到user.
    public User findByUname(String uname){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("u_name",uname);
        List<User> users = userDao.selectList(queryWrapper);
        if(users !=null && users.size()>0){
            return users.get(0);
        }else {
            return null;
        }
    }
}
