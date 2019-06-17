package com.springcloud.dao;

import com.springcloud.entity.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
    
    /**
     * 查询指定订单的订单明细
     * @param orderId	订单编号
     * @return	成功返回java.util.List类型实例，否则返回null
     */
    public abstract List<OrderDetail> selectByOrderId(Integer orderId);
}