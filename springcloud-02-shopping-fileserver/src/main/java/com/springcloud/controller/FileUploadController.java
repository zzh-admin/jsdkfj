package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userImage") MultipartFile file) {

		ResultValue rv = new ResultValue();

		try {
			Map<String, Object> map = this.uploadFile(userPath, file);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("閻€劍鍩涙径鏉戝剼娑撳﹣绱舵径杈Е閿涗緤绱掗敍锟�");
		return rv;
	}

	/**
	 * 娑撳﹣绱堕弬鍥︽
	 * 
	 * @param path 娑撳﹣绱堕弬鍥︽閻ㄥ嫯鐭惧锟�
	 * @param file 娑撳﹣绱堕惃鍕瀮娴狅拷
	 * @return 閹存劕濮涙潻鏂挎礀java.util.Map缁鐎烽惃鍕杽娓氬绱濋崥锕�鍨潻鏂挎礀null
	 */
	@RequestMapping(value = "/goodsUpload")
	private ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		ResultValue rv = new ResultValue();

		try {
			Map<String, Object> map = this.uploadFile(goodsPath, file);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("閻€劍鍩涙径鏉戝剼娑撳﹣绱舵径杈Е閿涗緤绱掗敍锟�");
		return rv;
	}

	@RequestMapping(value="/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg")String goodsImg) {
		ResultValue rv = new ResultValue();
		try {
			int indexOf = goodsImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = goodsImg.substring(indexOf + 1);
				File file = new File(this.goodsPath + fileName);
				//判断文件或目录是否存在
				if(file.exists()) {
					if(file.isFile()) {
						file.delete();
						
						rv.setCode(0);
						return rv;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	@RequestMapping(value="/deleteuserImg")
	public ResultValue deleteuserImg(@RequestParam("userImg")String userHphoto) {
		ResultValue rv = new ResultValue();
		try {
			int indexOf = userHphoto.lastIndexOf("/");
			String fileName = null;
			if(indexOf != -1) {
				fileName = userHphoto.substring(indexOf + 1);
				File file = new File(this.userPath + fileName);
				//判断文件或目录是否存在
				if(file.exists()) {
					if(file.isFile()) {
						file.delete();
						
						rv.setCode(0);
						return rv;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	

	private Map<String, Object> uploadFile(String path, MultipartFile file) throws IOException {
		String fileName = UploadUtils.getFileName();
		String exentedName = UploadUtils.getExendedName(file.getOriginalFilename());
		byte[] bytes = file.getBytes();
		File saveFile = new File(path + fileName + exentedName);
		FileCopyUtils.copy(bytes, saveFile);
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("exentedName", exentedName);
		return map;
	}
}
