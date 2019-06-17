package com.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 持久化层：定义对USERS表进行操作的方法
 * 
 * @author hp
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users> {

	/**
	 * 判断用户是否登录成功
	 * 
	 * @param userId       用户编号
	 * @param userPsw      用户密码
	 * @param permissionId 用户权限编号
	 * @return 成功则返回登录用户完整的信息，失败则返回null
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userNumber,u.userPsw,u.userSex,u.userPhone,u.userSite,u.userBirthday,u.userEmail,u.userHphoto,u.idictionId,u.userStatus) "
			+ "from Users u where u.userId=:userId and u.userPsw=:userPsw and u.idictionId=:idictionId and u.userStatus=0")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPsw") String userPsw,
			@Param("idictionId") Integer idictionId);
	
	/**
	 * 修改USER表中指定编号的用户状态
	 * @param userId	用户编号
	 * @param userStatus	用户状态
	 * @return	修改成功返回大于零的整数，否则返回小于等于零的整数
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId,@Param("userStatus") Integer userStatus);
	
	/**
	 * 修改USER表中指定编号的用户信息
	 * @param users	修改的用户信息
	 * @return	修改成功返回大于零的整数，否则返回小于等于零的整数
	 */
	@Modifying
	@Query("update Users u set u.userNumber=:#{#users.userNumber},u.userSex=:#{#users.userSex},u.userPhone=:#{#users.userPhone},"
			+ "u.userSite=:#{#users.userSite},u.userBirthday=:#{#users.userBirthday},u.userEmail=:#{#users.userEmail} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);
	
	/**
	 * 修改users表中指定USER_ID的用户头像
	 * @param users	修改的用户信息
	 * @return	成功返回大于零的整数，否则反会小于等于零的整数
	 */
	@Modifying
	@Query("update Users u set u.userHphoto=:#{#users.userHphoto} where u.userId=:#{#users.userId}")
	public abstract Integer updateImge(@Param("users") Users users);
	
	/**
	 * 	修改users表中指定USER_ID的用户密码
	 * @param users	修改的用户信息
	 * @return	成功返回大于零的整数，否则反会小于等于零的整数
	 */
	@Modifying
	@Query("update Users u set u.userPsw=:#{#users.userPsw} where u.userId=:#{#users.userId}")
	public abstract Integer updatePsw(@Param("users") Users users);
	
	/**
	 * 	修改users表中指定USER_ID的用户昵称
	 * @param users	修改的用户信息
	 * @return	成功返回大于零的整数，否则反会小于等于零的整数
	 */
	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);
}
