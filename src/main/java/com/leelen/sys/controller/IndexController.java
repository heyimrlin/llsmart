/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日下午1:53:08
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leelen.manage.repository.AdminUserRepository;
import com.leelen.my.mycontroller.LeelenController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xiaoxl
 *
 */

@LeelenController
@RequestMapping("/sys")
@Api(value = "Index-API")
public class IndexController {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	AdminUserRepository adminUserRepository;

	// @Resource
	// AdminUserService adminUserService;

	@RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
	public String index() {
		return "view/index";
	}

	@RequestMapping(value = "/manage/toadd", method = {RequestMethod.GET, RequestMethod.POST})
	public String toAdd() {
		return "manage/user/add";
	}

	// @RequestMapping(value="/manage/add",method=RequestMethod.POST)
	// @ResponseBody
	// public AppMsg add(AdminUser adminUser) {
	// AppMsg appMsg = new AppMsg();
	// adminUser.setAid(Ramdata.ramdaSw(8));
	// adminUser.setRoleid(1);
	// adminUser.setCreatetime(dateFormater.format(date));
	// adminUser.setToken(Config.GetGUID());
	// adminUserService.save(adminUser);
	// return appMsg.returnMsg(0, "添加成功", null);
	// }

}
