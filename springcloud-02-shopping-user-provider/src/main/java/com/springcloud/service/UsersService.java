package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

/**
 * 模型层的接口：用于定义用户模块的方法
 * @author hp
 *
 */
public interface UsersService {

	/**
	 * 验证用户登录是否成功
	 * @param userId	用户编号
	 * @param userPsw	用户密码
	 * @param idictionId	权限编号
	 * @return	成功返回登录用户的完整信息，失败返回null
	 */
	public abstract Users login(Integer userId,String userPsw,Integer idictionId);
	
	/**
	 * 添加新的用户信息
	 * @param users新的用户信息
	 * @return添加成功返回com.springcloud.entity.Users类型的实例，否则返回null
	 */
	public abstract Users insert(Users users);
	
	/**
	 * 查询满足条件的用户信息
	 * @param users	查询条件
	 * @param pageNumber	查询页数
	 * @return	成功返回org.springframework.data.domain.Page类型实例
	 */
	public abstract Page<Users> select(Users users,Integer pageNumber);
	
	/**
	 * 修改满足条件的用户信息
	 * @param userId	用户编号
	 * @param userStatus	用户状态
	 * @return
	 */
	
	public abstract Integer updateStatus(Integer userId,Integer userStatus);
	
	
	public abstract Users selectById(Integer userId);
	
	/**
	 * 修改指定编号的用户信息
	 * @param users	修改的用户信息
	 * @return	修改成功后返回
	 */
	public abstract Integer update(Users users);
	
	/**
	 * 根据参数修改指定编号用户的头像或密码或昵称
	 * @param users
	 * @return
	 */
	public abstract Integer updateMessage(Users users);
	
}
