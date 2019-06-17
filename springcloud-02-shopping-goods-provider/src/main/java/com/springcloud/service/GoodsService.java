package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

public interface GoodsService {

	public abstract Integer insert(Goods goods);

	/**
	 * 查询满足条件的商品信息（分页功能）
	 * 
	 * @param goods      查询条件
	 * @param PageNumber 页数
	 * @return 成功返回com.github.pagehelper.PageInfo<Goods>类型的实例，否则返回null
	 */
	public abstract PageInfo<Goods> select(Goods goods, Integer PageNumber);

	/**
	 * 根据条件修改商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功返回大于零的整数，否则反之
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 根据指定编号修改商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功返回大于零的整数，否则反之
	 */
	public abstract Integer update(Goods goods);

	/**
	 * 查询销量前十的商品信息
	 * 
	 * @return 成功返回java.util.List类型的实力，否则返回null
	 */
	public abstract List<Goods> selectGroup();
}
