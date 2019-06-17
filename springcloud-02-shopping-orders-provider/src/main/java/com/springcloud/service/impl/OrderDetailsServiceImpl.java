package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.dao.OrderDetailMapper;
import com.springcloud.entity.OrderDetail;
import com.springcloud.service.OrderDetailService;

/**
 * 订单明细模块模型层的实现类，用于实现爱你订单明细的方法
 * 
 * @author hp
 *
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	public PageInfo<OrderDetail> selectByOrderId(Integer orderId, Integer pageNumber) {

		// 设置分页信息
		PageHelper.startPage(pageNumber + 1, 5);
		List<OrderDetail> list = this.orderDetailMapper.selectByOrderId(orderId);
		// 查询满足条件的订单信息
		return new PageInfo<>(list);
	}
}
