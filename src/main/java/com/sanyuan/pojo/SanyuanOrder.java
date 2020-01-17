package com.sanyuan.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.sanyuan.utils.GlobalConst.Entity;

public class SanyuanOrder {
    private Long orderId;

    private Integer userNum;

    private Integer carId;

    private Integer proid;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private BigDecimal amount;

    private String remarks;
    public SanyuanOrder() {
    	
    }
    public SanyuanOrder(Long id,Integer userNum,Integer carId,Entity entity) {
    	orderId =id;
    	this.userNum=userNum;
    	proid=entity.id;
    	this.carId=carId;
    	amount=BigDecimal.valueOf(entity.pay);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}