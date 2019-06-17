package com.springcloud.dao;

import com.springcloud.entity.Goods;
import java.util.List;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer goodId);

	int insert(Goods record);

	Goods selectByPrimaryKey(Integer goodId);

	List<Goods> selectAll();

	int updateByPrimaryKey(Goods record);

	/**
	 * 查询Goods中满足条件的商品信息
	 * 
	 * @param goods 查询条件
	 * @return 成功返回java.util.List类型的实力，否则返回null
	 */
	public abstract List<Goods> select(Goods goods);

	/**
	 * 根据条件修改GOODS表中指定GOod_Id的商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功反悔大于零的整数，否则返回小于等于零的整数
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 查询销量前十的商品信息
	 * 
	 * @return 成功返回java.util.List类型的实力，否则返回null
	 */
	public abstract List<Goods> selectGroup();
}