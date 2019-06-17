package com.springcloud.service.impl;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.GoodsMapper;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;

@Service
public class GoodServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Transient
	@Override
	public Integer insert(Goods goods) {
		return null;
	}

	@Override
	public PageInfo<Goods> select(Goods goods, Integer pageNumber) {
		// 在商品名称两端加%
		goods.setGoodName("%" + goods.getGoodName() + "%");
		// 设置分页信息
		PageHelper.startPage(pageNumber + 1, PageUtils.PAGE_ROW_COUNT);
		List<Goods> list = this.goodsMapper.select(goods);
		// 查询满足条件的商品信息
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateGoodsById(Goods goods) {
		return this.goodsMapper.updateGoodsById(goods);
	}

	@Transactional
	@Override
	public Integer update(Goods goods) {
		return this.goodsMapper.updateByPrimaryKey(goods);
	}

	@Transactional
	@Override
	public List<Goods> selectGroup() {
		return this.goodsMapper.selectGroup();
	}

}
