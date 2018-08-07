/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.common.annotation.Log;
import com.leelen.databaseback.BatabaseBack;
import com.leelen.entitys.Leelen;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年6月11日上午10:02:49
 * @class DatabaseBack.java
 */
@LeelenRestController(msg = "数据库备份")
@RequestMapping("/app/databaseback")
public class DatabaseBackController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired // 自动注入，可以直接省略掉set和get，它会帮我们set和get
	Leelen leelen;

	@Value("${leelen.databaseip}")
	private String databaseip;

	@Value("${leelen.databaseusername}")
	private String databaseusername;

	@Value("${leelen.databasepwd}")
	private String databasepwd;

	@Value("${leelen.databasepath}")
	private String databasepath;

	@Value("${leelen.databasename}")
	private String databasename;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();

	@Log("数据库备份")
	@RequestMapping(value = "/databaseback", method = RequestMethod.GET)

	public RespEntity databaseBack(@RequestParam(value = "appkey") String appkey) {
		if (BatabaseBack.backup(databaseip, databaseusername, databasepwd, "databasepath", dateFormater.format(date),
				databasename)) {
			logger.info(dateFormater.format(date) + "数据库备份成功");
			return new RespEntity(RespCode.DATABASEBACK_SUCCESS, null);
		} else {
			logger.info(dateFormater.format(date) + "数据库备份失败");
			return new RespEntity(RespCode.DATABASEBACK_FAIL, null);
		}
	}
}
