package com.springcloud.dao;

import com.springcloud.entity.Orders;
import java.util.List;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Orders record);

	Orders selectByPrimaryKey(Integer orderId);

	List<Orders> selectAll();

	int updateByPrimaryKey(Orders record);

	/**
	 * 查询ORDERS表中瞒住条件的信息
	 * 
	 * @param orders 查询条件
	 * @return 成功返回java.util.List类型实例，否则返回null
	 */
	public abstract List<Orders> selectOrders(Orders orders);
	/**
	 * 	修改ORDERS表中指定ORDER_ID的状态
	 * @param orders	修改订单的信息
	 * @return	成功返回大于零的整数，失败返回小于等于零的整数
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
	/**
	 * 查询指定范围内的销售额
	 * @param orders	查询条件
	 * @return	成功返回java.util.List类型实例，否则返回null
	 */	
	public abstract List<Orders> selectGroup(Orders orders);
}