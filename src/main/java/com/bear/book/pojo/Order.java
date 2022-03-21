package com.bear.book.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/4 22:06
 */
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    private Integer status = Order.NOT_SHIPPED;
    private Integer userId;

    /**
     * 未发货
     */
    public static final Integer NOT_SHIPPED = 0;
    /**
     * 运输中
     */
    public static final Integer TRANSPORTING = 1;
    /**
     * 已签收
     */
    public static final Integer RECEIVED = 2;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
