/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日下午4:49:09
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaoxl
 *
 */

@Controller
@RequestMapping("/sys/user")
public class UserWebController {

	@RequestMapping("/toAdd")
	public String toAddUser() {
		return "view/user/add";
	}

	// @Resource
	// UserService userService;
	//
	// @RequestMapping(value="/add",method=RequestMethod.POST)
	// public @ResponseBody String useradd(User user) {
	// userService.save(user);
	// return "添加成功";
	// }

}
