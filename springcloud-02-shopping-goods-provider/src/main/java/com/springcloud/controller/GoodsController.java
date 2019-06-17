package com.springcloud.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Goods;
import com.springcloud.service.GoodsService;
import com.springcloud.vo.ResultValue;

/**
 * ��Ʒģ����Ʋ�
 * @author ��Ӧ��
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/insert")
	public ResultValue insert(Goods goods) {
		ResultValue rv = new ResultValue();
		try {
			////调用service相应的方法添加新的商品信息，并且得到添加是否成功
			Integer insert = this.goodsService.insert(goods);
			//如果查询成功
			if(insert > 0) {
				//设置结果状态为0
				rv.setCode(0);
				rv.setMessage("商品信息录入成功");
				//返回ResultValue对象
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("商品信息录入失败");
		return rv;
	}
	
	@RequestMapping(value = "/select")
	public ResultValue select(Goods goods,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			//查询满足条件的商品信息
			PageInfo<Goods> pageInfo = this.goodsService.select(goods, pageNumber);
			//从分页信息中获取商品信息
			List<Goods> list = pageInfo.getList();
			//如果查询到了满足条件的商品信息
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				//将商品信息已制定的键存入Map集合
				map.put("goodsList",list);
				
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
	/**
	 * 修改指定商品信息
	 * @param goods	修改的商品信息
	 * @return	成功返回大于零的整数，失败则返回小于等于零的整数
	 */
	@RequestMapping(value="/updateById")
	public ResultValue updateById(Goods goods) {
		ResultValue rv = new ResultValue();
		try {
			Integer updateGoodsById = this.goodsService.updateGoodsById(goods);
			if(updateGoodsById > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功！！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品信息修改失败！！！");
		return rv;
	}
	/**
	 * 修改指定编号商品信息
	 * @param goods
	 * @return
	 */
	@RequestMapping(value="/update")
	public ResultValue update(Goods goods) {
		ResultValue rv = new ResultValue();
		try {
			Integer updateGoodsById = this.goodsService.update(goods);
			if(updateGoodsById > 0) {
				rv.setCode(0);
				rv.setMessage("商品信息修改成功！！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品信息修改失败！！！");
		return rv;
	}
	/**
	 * 查询销量前十的商品信息
	 * @return
	 */
	@RequestMapping(value="/selectGroup")
	public ResultValue selectGroup() {
		ResultValue rv = new ResultValue();
		try {
			List<Goods> list = this.goodsService.selectGroup();
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				//创建两个集合用于保存柱状图
				List<String> x = new ArrayList<>();
				List<Integer> y = new ArrayList<>();
				//将查询结果中的商品名称存入x轴，将查询结果中的销量放入Y轴
				for(Goods goods : list) {
					x.add(goods.getGoodName());
					y.add(goods.getGoodsSum());
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
		rv.setMessage("查询销量前十的商品信息失败！！！");
		return rv;
	}
}
