package com.cqut.cqutcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value = "dev_plan")
public class DevPlan {
    @TableId(value = "dp_id",type = IdType.AUTO)
    private Integer dpId;
    @TableField(value = "dp_plandate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dpPlandate;
    @TableField(value = "dp_plancontent")
    private String dpPlancontent;
    @TableField(value = "dp_execase")
    private String dpExecase;
    @TableField(value = "dp_exedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dpExedate;
    @TableField(value = "dp_exemanager")
    private String dpExemanager;
    @TableField(value = "sc_id")
    private Integer scId;


    public Date getDpPlandate() {
        return dpPlandate;
    }

    public void setDpPlandate(Date dpPlandate) {
        this.dpPlandate = dpPlandate;
    }

    public String getDpPlancontent() {
        return dpPlancontent;
    }

    public void setDpPlancontent(String dpPlancontent) {
        this.dpPlancontent = dpPlancontent;
    }

    public String getDpExecase() {
        return dpExecase;
    }

    public void setDpExecase(String dpExecase) {
        this.dpExecase = dpExecase;
    }

    public Date getDpExedate() {
        return dpExedate;
    }

    public void setDpExedate(Date dpExedate) {
        this.dpExedate = dpExedate;
    }

    public String getDpExemanager() {
        return dpExemanager;
    }

    public void setDpExemanager(String dpExemanager) {
        this.dpExemanager = dpExemanager;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }
}
