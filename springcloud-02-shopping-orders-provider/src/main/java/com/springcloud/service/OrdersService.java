package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * 查询满足条件的订单信息（分页功能）
 * 
 * @author hp
 *
 */
public interface OrdersService {

	/**
	 * 查询满足条件的订单信息（分页功能）
	 * 
	 * @param orders 查询条件
	 * @return 成功返回com.github.pagehelper.PageInfo<Orders>类型的实例，否则返回null
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders, Integer PageNumber);

	/**
	 * 修改指定定胆的订单状态
	 * 
	 * @param orders 修改的订单信息
	 * @return
	 */
	public abstract Integer updateOrdersStatus(Orders orders);

	/**
	 * 查询指定日期范围内的销售额
	 * 
	 * @param orders 查询的条件
	 * @return	成功返回java.util.List类型实例，否则返回null
	 */
	public abstract List<Orders> selectGroup(Orders orders);
}
