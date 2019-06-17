package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 订单模块的控制层
 * @author hp
 *
 */

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {

		ResultValue rv = new ResultValue();
		try {
			//查询满足条件的商品信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders,pageNumber);
			List<Orders> list = pageInfo.getList();
			if(list != null && list.size() > 0) {
				rv.setCode(0);;
				Map<String,Object> map = new HashMap<>();
				map.put("ordersList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages()*PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("修改成功！！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		rv.setCode(1);
		rv.setMessage("修改失败！！！");
		return rv;
	}
	@RequestMapping(value="/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				//创建两个集合用于保存柱状图
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				//将查询结果中的商品名称存入x轴，将查询结果中的销量放入Y轴
				for(Orders order : list) {
					//用于保存查询结果的月份
					x.add(order.getOrderMonth());
					//用于保存查询结果的销售额
					y.add(order.getOrderPrice());
				}
				Map<String,Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("查询指定点单信息失败！！！");
		return rv;
	}
	
	}
