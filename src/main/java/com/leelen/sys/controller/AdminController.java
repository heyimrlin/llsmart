/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月18日下午4:51:48
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.AdministratorService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Administrator;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl
 *
 */
@Api(value = "Admin-API", description = "管理员接口")
@LeelenRestController
@RequestMapping("/pt")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	AdministratorService administratorService;

	// 添加管理员
	// 账号、密码、昵称、手机号、角色、创建人、
	@Log("添加管理员")
	@ResponseBody
	@RequestMapping(value = "/addAdministrator", method = {RequestMethod.GET}, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value="添加管理员", notes = "添加管理员账号，返回RespEntity类型实体")
	@ApiImplicitParams({@ApiImplicitParam(name = "nickname", value = "管理员昵称", paramType = "form" ,dataType = "String"),
            @ApiImplicitParam(name = "account", value = "管理员账号", paramType = "form" ,dataType = "String"),
            @ApiImplicitParam(name = "tell", value = "管理员手机号", paramType = "form" ,dataType = "String"),
            @ApiImplicitParam(name = "password", value = "管理员密码", paramType = "form" ,dataType = "String"),
            @ApiImplicitParam(name = "roleid", value = "角色创建人标识", paramType = "query" ,dataType = "String")})
	@ApiResponse(code = 200, message = "保存成功")
	public RespEntity addAdministrator(HttpServletRequest request, @RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "account") String account, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "password") String password, @RequestParam(value = "roleid") String roleid) {
		// logger.info("添加管理员:" + administrator.getAccount() + ">>tell:" +
		// administrator.getTell());
		Administrator administrator = new Administrator();
		administrator.setAccount(account);
		administrator.setNickname(nickname);
		administrator.setTell(tell);
		administrator.setPassword(password);
		administrator.setRoleid(roleid);
		return administratorService.save(request, administrator);
	}

	// 平台登录
	@Log("平台登录")
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	@ApiOperation(value = "平台登录", notes = "平台登录")
	@ApiImplicitParams({@ApiImplicitParam(name = "accounttell", value = "管理员手机号", paramType = "form", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "管理员密码", paramType = "form" ,dataType = "String"),
			@ApiImplicitParam(name = "vcode", value = "验证码", paramType = "form" ,dataType = "String")})
	@ApiResponse(code = 200, message = "请求成功")
	public RespEntity adminLogin(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "accounttell") String accounttell, @RequestParam(value = "password") String password,
			@RequestParam(value = "vcode") String vcode) {
		logger.info("物业端app登录");
		long timestamp = 0;
		String sign = "93leelen";
		Cookie cookie = new Cookie("accounttell", accounttell.trim());
		cookie.setMaxAge(10 * 60);// 设置为10min
		cookie.setPath("/");
		logger.info("已添加cookie===============");
		response.addCookie(cookie);// 通过cookie获取管理员判断角色、权限
		return administratorService.adminLogin(accounttell, password, timestamp, sign);//
	}

	// 获取所有管理员
	@Log("获取所有管理员")
	@RequestMapping(value = "/getAllAdministrator", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "获取所有管理员", notes = "获取所有管理员账号信息")
	@ApiResponse(code = 200, message = "请求成功", response = Administrator.class)
	public List<Administrator> getAllAdministrator() {
		return administratorService.getAllAdministrator();
	}

	// 修改管理员状态
	@Log("修改管理员状态")
	@RequestMapping(value = "/updateAdminStatus", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "修改管理员状态", notes = "设置管理员账号是否可用")
	@ApiImplicitParams({@ApiImplicitParam(name = "tell", value = "管理员手机号", paramType = "form", dataType = "String"),
			@ApiImplicitParam(name = "isuse", value = "是否可用", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "请求成功")
	public RespEntity updateAdminStatus(@RequestParam(value = "tell") String tell,
			@RequestParam(value = "isuse") int isuse) {
		return administratorService.UpDateAdministratorOfIsuse(isuse, tell);
	}

	// public String

	// @Scheduled(cron = "00 * * * * *")
	// public void cronAdmin() throws Exception {
	// SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// Date date = new Date();
	// // String date = MyMethod.getDate();
	// System.out.println("测试执行定时任务(每一分钟的第00秒执行):" + dateFormater.format(date));
	// }

}
