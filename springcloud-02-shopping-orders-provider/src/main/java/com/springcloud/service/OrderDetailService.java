package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;

/**
 * 订单明细模块的模型层，用于定义订单明细模块的方法
 * @author hp
 *
 */
public interface OrderDetailService {

	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNumber);
}
