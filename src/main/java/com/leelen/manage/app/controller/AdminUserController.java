/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月9日上午8:46:05
 * @包名:com.leelen.manage.app.controller
 * @描述:TODO
 */
package com.leelen.manage.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoxl
 *
 */
@RestController
@RequestMapping("/manage")
public class AdminUserController {

	// @Resource
	// AdminUserService adminUserService;
	//
	// @Log("管理端-登录")
	// @RequestMapping("/login")
	// public ApiMsg login(HttpServletRequest request, @RequestParam(value =
	// "account") String account,
	// @RequestParam(value = "password") String password) {
	// String sign = request.getParameter("sign");
	// long timestamp = Long.parseLong(request.getParameter("timestamp"));
	// return adminUserService.login(account, password, sign, timestamp);
	// }
	//
	// //
	// @Log("管理端-修改密码")
	// @RequestMapping("/modifyPwd")
	// public ApiMsg modifyPwd(HttpServletRequest request, @RequestParam(value =
	// "token") String token,
	// @RequestParam(value = "oldpwd") String oldpwd, @RequestParam(value =
	// "newpwd") String newpwd) {//注:oldpwd原密码 换 短信验证码
	// String sign = request.getParameter("sign");
	// long timestamp = Long.parseLong(request.getParameter("timestamp"));
	// return adminUserService.modifyPwd(token, oldpwd, newpwd, sign, timestamp);
	// }
	//
	// @Log("管理端-重置密码")
	// @RequestMapping("/resetPwd")
	// public ApiMsg resetPwd(HttpServletRequest request, @RequestParam(value =
	// "token") String token,
	// @RequestParam(value = "pwd") String pwd) {
	// String sign = request.getParameter("sign");
	// long timestamp = Long.parseLong(request.getParameter("timestamp"));
	// return adminUserService.resetPwd(token, pwd, sign, timestamp);
	// }

}
