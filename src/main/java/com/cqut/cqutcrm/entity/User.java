package com.cqut.cqutcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value= "user")//指定实体类对应的表格
public class User {
    @TableId(type= IdType.AUTO,value="u_id")//指定主键对应列
    private Integer uId;
    @TableField(value="u_name")//如果字段名和列名一致，可以省略这个注解
    private String uName;
    @TableField(value="u_password")
    private String uPassword;
    @TableField(value="r_id")
    private Integer rId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}
