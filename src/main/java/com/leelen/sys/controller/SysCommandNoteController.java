/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.CommandNoteService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.CommandNote;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午3:59:05
 * @class SysCommandNoteController.java
 */
@LeelenController(msg = "口令生成记录")
@RequestMapping("/sys/comm")
public class SysCommandNoteController {

	@Resource
	CommandNoteService commandNoteService;

	@Log("口令生成记录")
	@RequestMapping("/list")
	public @ResponseBody List<CommandNote> getCommand() {
		return commandNoteService.getCommandNote();
	}
}
