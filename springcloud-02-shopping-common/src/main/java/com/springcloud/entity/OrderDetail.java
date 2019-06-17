package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ORDERS表对应的实体类，拥有封装一行订单明细信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2281236879693007932L;

	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;
	/**
	 * 订单编号
	 */
	private Integer orderId;
	/**
	 * 商品编号
	 */
	private Integer goodId;
	/**
	 * 商品名称
	 */
	private String goodName;
	/**
	 * 成交价
	 */
	private Double transactionPrice;
	/**
	 * 成交数量
	 */
	private Integer transactionCount;
}