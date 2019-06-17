package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable {
	/**
	 * ORDERS琛ㄥ搴旂殑瀹炰綋绫伙紝鎷ユ湁灏佽涓�琛岃鍗曚俊鎭�
	 */
	private static final long serialVersionUID = -2654903722643765558L;

	/**
	 * 璁㈠崟缂栧彿
	 */
	private Integer orderId;

	/**
	 * 褰撳墠璁㈠崟鐨勭敤鎴蜂俊鎭�
	 */
	private Users user;

	/**
	 * 鏀惰揣浜哄鍚�
	 */
	private String consigneeName;

	/**
	 * 鏀惰揣浜鸿仈绯荤數璇�
	 */
	private String consigneeNumber;

	/**
	 * 鏀惰揣浜哄湴鍧�
	 */
	private String consigneeSite;
	/**
	 * 涓嬪崟鏃堕棿
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderTime;
	/**
	 * 璁㈠崟鎬绘暟
	 */
	private Double orderAmount;
	/**
	 * 璁㈠崟鐘舵��
	 */
	private Integer orderStatus;
	/**
	 * 订单起始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMin;
	/**
	 * 订单终止时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMax;
	/**
	 * 起始月份
	 */
	private String startMonth;
	/**
	 * 终止年月
	 */
	private String endMonth;
	/**
	 * 统计结果的年月
	 */
	private String orderMonth;
	/**
	 * 统计结果的销售额
	 */
	private Double orderPrice;
}