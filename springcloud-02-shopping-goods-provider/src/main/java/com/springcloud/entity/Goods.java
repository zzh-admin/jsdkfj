package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	/**
	 * 商品编号
	 */
	private Integer goodId;
	/**
	 * 商品名称
	 */

	private String goodName;

	/**
	 * 商品价格
	 */
	private Double goodPrices;
	/**
	 * 商品折扣价
	 */

	private Double goodDiscount;
	/**
	 * 商品状态
	 */

	private Integer goodStatus;
	/**
	 * 商品数量
	 */

	private Integer goodCount;

	/**
	 * 是否新品
	 */
	private Integer goodIsNew;
	/**
	 * 是否热卖
	 */

	private Integer goodIsHot;
	/**
	 * 商品级别
	 */

	private Integer goodLevel;
	/**
	 * 商品简介
	 */

	private String goodBrief;
	/**
	 * 商品详情
	 */

	private String goodDetails;

	/**
	 * 商品图片
	 */
	private String goodPhoto;
	/**
	 * 二级类别编号
	 */

	private Integer class2Id;
	/**
	 * 商品价格的下线
	 */
	private Double goodPriceMin;

	/**
	 * 商品价格的上限
	 */
	private Double goodPriceMax;
	/**
	 * 一级类别编号
	 */
	private Integer class1Id;

	/**
	 * 商品销量:用于保存统计分组的结果
	 */
	private Integer goodsSum;

}