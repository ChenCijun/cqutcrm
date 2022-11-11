package com.cqut.cqutcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value="sale_chance")
public class SaleChance {
    @TableId(value="sc_id",type= IdType.AUTO)
    private Integer scId;
    @TableField(value="sc_cusname")
    private String scCusname;
    @TableField(value="sc_comming")
    private String scComming;
    @TableField(value="sc_name")
    private String scName;
    @TableField(value="sc_phone")
    private String scPhone;
    @TableField(value="sc_success")
    private String scSuccess;
    @TableField(value="sc_message")
    private String scMessage;
    @TableField(value="sc_desc")
    private String scDesc;
    @TableField(value="sc_user")
    private String scUser;
    @TableField(value="sc_createtime")
    //前端传输的日期格式字符串，转换为date类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm;ss")
    //把date类型，格式为指定字符串，方便传输到前端使用
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date scCreatetime;
    @TableField(value="sc_giveuser")
    private String scGiveuser;
    @TableField(value="sc_givetime")
    //前端传输的日期格式字符串，转换为date类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm;ss")
    //把date类型，格式为指定字符串，方便传输到前端使用
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date scGivetime;
    @TableField(value="sc_status")
    private Integer scStatus;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScCusname() {
        return scCusname;
    }

    public void setScCusname(String scCusname) {
        this.scCusname = scCusname;
    }

    public String getScComming() {
        return scComming;
    }

    public void setScComming(String scComming) {
        this.scComming = scComming;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getScPhone() {
        return scPhone;
    }

    public void setScPhone(String scPhone) {
        this.scPhone = scPhone;
    }

    public String getScSuccess() {
        return scSuccess;
    }

    public void setScSuccess(String scSuccess) {
        this.scSuccess = scSuccess;
    }

    public String getScMessage() {
        return scMessage;
    }

    public void setScMessage(String scMessage) {
        this.scMessage = scMessage;
    }

    public String getScDesc() {
        return scDesc;
    }

    public void setScDesc(String scDesc) {
        this.scDesc = scDesc;
    }

    public String getScUser() {
        return scUser;
    }

    public void setScUser(String scUser) {
        this.scUser = scUser;
    }

    public Date getScCreatetime() {
        return scCreatetime;
    }

    public void setScCreatetime(Date scCreatetime) {
        this.scCreatetime = scCreatetime;
    }

    public String getScGiveuser() {
        return scGiveuser;
    }

    public void setScGiveuser(String scGiveuser) {
        this.scGiveuser = scGiveuser;
    }

    public Date getScGivetime() {
        return scGivetime;
    }

    public void setScGivetime(Date scGivetime) {
        this.scGivetime = scGivetime;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }
}
