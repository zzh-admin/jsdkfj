package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * 鎺у埗灞傦細鎺ュ彈瑙嗗浘灞傜殑鏁版嵁锛屽苟璋冪敤妯″瀷灞傜浉搴旂殑鏂规硶锛屽皢鏁版嵁杩斿洖鍒拌鍥惧眰涓�
 * 
 * @author hp
 *
 */
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	/**
	 * 鐢ㄦ埛淇℃伅
	 * 
	 * @param userId鐢ㄦ埛缂栧彿
	 * @param userPsw鐢ㄦ埛瀵嗙爜
	 * @param idictionId鏉冮檺缂栧彿
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ResultValue login(@RequestParam("userId") Integer userId, @RequestParam("userPsw") String userPsw,
			@RequestParam("idictionId") Integer idictionId) {
		ResultValue rv = new ResultValue();
		try {
			Users login = this.usersService.login(userId, userPsw, idictionId);
			if (login != null) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				return rv;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("鐧诲綍淇℃伅涓嶆纭紝璇烽噸鏂拌緭鍏ワ紒");
		return rv;
	}

	@RequestMapping(value = "/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Users insert = this.usersService.insert(users);
			if (insert != null) {
				rv.setCode(0);
				rv.setMessage("鐢ㄦ埛褰曞叆鎴愬姛锛侊紒锛�");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("鐢ㄦ埛褰曞叆澶辫触锛侊紒锛�");
		return rv;
	}

	@RequestMapping(value = "/select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			List<Users> list = page.getContent();
			if (list != null && list.size() > 0) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				map.put("userList", list);
				PageUtils pageUtils = new PageUtils((int) page.getTotalElements());
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

	@RequestMapping(value = "/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,
			@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if (status > 0) {
				rv.setCode(0);
				rv.setMessage("鐢ㄦ埛鐘舵�佷慨鏀规垚鍔燂紒锛侊紒");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		rv.setCode(1);
		rv.setMessage("鐢ㄦ埛鐘舵�佷慨鏀瑰け璐ワ紒锛侊紒");
		return rv;
	}

	/**
	 * 查询指定编号的用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		try {
			Users users = this.usersService.selectById(userId);
			if (users != null) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("user", users);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("获取信息失败！！！");
		return rv;
	}

	@RequestMapping(value = "/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		try {
			// 调用service中相应的方法修改用户信息，并获得修改是否成功
			Integer update = this.usersService.update(users);
			// 如果修改成功
			if (update > 0) {
				// 设置结果的状态为0
				rv.setCode(0);
				// 返回ResultValue的对象
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户信息修改失败！！！");
		return rv;
	}

	@RequestMapping(value = "/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Integer message = this.usersService.updateMessage(users);
			if (message > 0) {
				rv.setCode(0);
				rv.setMessage("用户信息修改成功！！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户信息修改失败！！！");
		return rv;
	}
}