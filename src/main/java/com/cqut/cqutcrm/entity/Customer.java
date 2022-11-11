package com.cqut.cqutcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "customer")
public class Customer {
    @TableId(value = "cus_id", type= IdType.AUTO)
    private Integer cusId;
    @TableField(value = "cus_name")
    private String cusName;
    @TableField(value = "cus_region")
    private Integer cusRegion;
    @TableField(value = "cus_industry")
    private Integer cusIndustry;
    @TableField(value = "cus_level")
    private String cusLevel;
    @TableField(value = "cus_satisfy")
    private Integer cusSatisfy;
    @TableField(value = "cus_credit")
    private Integer cusCredit;
    @TableField(value = "cus_addr")
    private String cusAddr;
    @TableField(value = "cus_zipcode")
    private Integer cusZipcode;
    @TableField(value = "cus_phone")
    private String cusPhone;
    @TableField(value = "cus_fax")
    private String cusFax;
    @TableField(value = "cus_url")
    private String cusUrl;
    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value = "cus_status")
    private Integer cusStatus;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Integer getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(Integer cusRegion) {
        this.cusRegion = cusRegion;
    }

    public Integer getCusIndustry() {
        return cusIndustry;
    }

    public void setCusIndustry(Integer cusIndustry) {
        this.cusIndustry = cusIndustry;
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    public Integer getCusSatisfy() {
        return cusSatisfy;
    }

    public void setCusSatisfy(Integer cusSatisfy) {
        this.cusSatisfy = cusSatisfy;
    }

    public Integer getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(Integer cusCredit) {
        this.cusCredit = cusCredit;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public Integer getCusZipcode() {
        return cusZipcode;
    }

    public void setCusZipcode(Integer cusZipcode) {
        this.cusZipcode = cusZipcode;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(Integer cusStatus) {
        this.cusStatus = cusStatus;
    }
}
