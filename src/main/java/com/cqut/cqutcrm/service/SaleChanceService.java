package com.cqut.cqutcrm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqut.cqutcrm.dao.SaleChanceDao;
import com.cqut.cqutcrm.entity.SaleChance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service //注解功能：spring框架创建对象
public class SaleChanceService {


    @Autowired//注解功能：spring容器中找到SaleChanceDao的实现类的对象，赋值给变量saleChanceDao
    SaleChanceDao saleChanceDao;

    //1.定义查询所有的方法
    public List<SaleChance> queryAll(){
        List<SaleChance> list = saleChanceDao.selectList(null);
        return list;
    }

    //---查询指定页的数据
    public IPage<SaleChance> getOnePage(Integer page, Integer rows){
        IPage<SaleChance> ipage = new Page<>(page,rows);//页码，一行的行数
        ipage = saleChanceDao.selectPage(ipage,null);
        return ipage;
    }

    //2.定义添加销售机会的方法
    public boolean addSc(SaleChance sc){
        // -- 初次添加销售机会的时候，需要设置：销售机会状态为0，添加的人(登录用户)，添加的时间
        sc.setScStatus(0);
        sc.setScCreatetime(new Date());
        int row = saleChanceDao.insert(sc);
        return row > 0 ? true : false;
    }
    //3.提供一个根据主键更新的方法
    public boolean updateSc(SaleChance sc){
        int row = saleChanceDao.updateById(sc);
        return row > 0 ? true : false;
    }
    //4.提供一个根据主键删除的方法
    public boolean deleteSc(Integer scId){
        int row = saleChanceDao.deleteById(scId);
        return row > 0 ? true : false;
    }

    //5.提供一个根据分配的客户经理的名字，进行查询的方法。
    public IPage<SaleChance> getOnePageByGivename(Integer page,Integer rows,String uname){
        IPage<SaleChance> iPage = new Page<>(page,rows);
        QueryWrapper<SaleChance> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sc_giveuser",uname);
        iPage = saleChanceDao.selectPage(iPage,queryWrapper);
        return iPage;
    }

    //6.根据销售机会scID，查询销售机会
    public SaleChance queryByScId(Integer scId){
        return saleChanceDao.selectById(scId);
    }
}
