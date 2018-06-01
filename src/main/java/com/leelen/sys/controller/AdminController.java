/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月18日下午4:51:48
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.AdministratorService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Administrator;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl
 *
 */
@LeelenRestController
@RequestMapping("/pt")
public class AdminController {

	@Resource
	AdministratorService administratorService;

	@Log("获取所有管理员")
	@RequestMapping(value = "/getAllAdministrator", method = RequestMethod.GET)
	public List<Administrator> getAllAdministrator() {
		return administratorService.getAllAdministrator();
	}

	// 修改管理员状态
	@Log("修改管理员状态")
	@RequestMapping("/updateAdminStatus")
	public RespEntity updateAdminStatus(@RequestParam(value = "tell") String tell,
			@RequestParam(value = "isuse") int isuse) {
		return administratorService.UpDateAdministratorOfIsuse(isuse, tell);
	}

	// public String

}
