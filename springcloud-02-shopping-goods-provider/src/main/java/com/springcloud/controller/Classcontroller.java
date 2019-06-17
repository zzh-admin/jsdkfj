package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Class1;
import com.springcloud.entity.Class2;
import com.springcloud.service.ClassService;
import com.springcloud.vo.ResultValue;

/**
 * 涓�绾х被鍒拰浜岀骇绫诲埆鐨勬帶鍒跺櫒
 * @author hp
 *
 */
@RestController
@RequestMapping("class")
public class Classcontroller {

	@Autowired
	private ClassService classService;
	
	@RequestMapping(value="/selectAll")
	
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		try {
			//璋冪敤service鐩稿簲鐨勬柟娉曟煡璇㈡墍鏈変竴绾х被鍒殑淇℃伅锛屽苟淇濆瓨鏌ヨ鐨勭粨鏋�
			List<Class1> list = this.classService.selectAllClass1();
			if(list != null&list.size()>0) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				map.put("class1List", list);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/selectById")
	public ResultValue selectById(@RequestParam("Class1Id") Integer Class1Id) {
		ResultValue rv = new ResultValue();
		try {
			List<Class2>  list = this.classService.selectClass2ByClass1Id(Class1Id);
			if(list != null&list.size()>0) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				map.put("class2List", list);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
}
