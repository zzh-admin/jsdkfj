package com.springcloud.common;

import java.util.Date;

/**
 * 文件上传的工具类
 * @author hp
 *
 */
public class UploadUtils {

	/**
	 * 获得新的文件名称（毫秒数+4位随机数）
	 * @return 返回新的文件名称
	 */
	public static String getFileName() {
		String fileName = null;
		
		//获得1~1000的随机数
		int num = (int)(Math.random()*1000 + 1);
		
		//将随机数设置为4位数
		String tempNum = "000" + num;
		tempNum = tempNum.substring(tempNum.length()-4);
		
		Date date = new Date();
		fileName = date.getTime() + tempNum;
		
		return fileName;
	}
	
	/**
	 * 返回文件扩展名
	 * @param fileName 文件名
	 * @return 成功返回文件扩展名，否则返回null
	 */
	public static String getExendedName(String fileName) {
		if(fileName == null || fileName.length()==0) {
			return null;
		}

	//获得文件名，最后一次出现的位置
	int index = fileName.lastIndexOf(".");
	if(index == -1) {
		return null;
	}
	return fileName.substring(index);
	}
//	public static void main(String[] args) {
//		System.out.print(getExendedName("abcd.efg.jpg"));
//	}

	
//	public static void main(String[] args) {
//		for(int i=0;i<10;i++)
//			System.out.print(getFileName());
//	}
}
