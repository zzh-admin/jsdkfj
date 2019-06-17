package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.Class1;
import com.springcloud.entity.Class2;

/**
 * 用于定义一级类别与二级类别模块的方法
 * @author hp
 *
 */
public interface ClassService {

	/**
	 * 查询所有一级类别的信息
	 * @return	成功返回Java.util.List类型实例，否则返回null
	 */
	public abstract List<Class1> selectAllClass1();
	/**
	 * 根据一级类型商品
	 * @param Class1Id
	 * @return
	 */
	public abstract List<Class2> selectClass2ByClass1Id(Integer Class1Id);
}
