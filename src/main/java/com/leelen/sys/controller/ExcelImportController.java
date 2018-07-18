/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.utils.ExcelImportUtils;

/**
 * @author xiaoxl by male
 * @time 2018年6月12日下午5:14:46
 * @class ExcelImportController.java
 */
@LeelenRestController(msg = "excel数据导入数据库mysql")
@RequestMapping(value = "/sys/excelimport")
public class ExcelImportController {

	@Log("excel数据导入数据库mysql")
	@RequestMapping(value = "/batchImport", method = RequestMethod.POST)
	public RespEntity batchImport(@RequestParam(value = "filename") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			/* @SessionAttribute(Constants.ACCOUNT_SESSION_KEY) */ Account account) throws IOException {

		// 判断文件是否为空
		if (file == null) {
			session.setAttribute("msg", "文件不能为空！");
			return new RespEntity(RespCode.DATA_IMPORT_FAIL, null);
		}

		// 获取文件名
		String fileName = file.getOriginalFilename();

		// 验证文件名是否合格
		if (!ExcelImportUtils.validateExcel(fileName)) {
			session.setAttribute("msg", "文件必须是excel格式！");
			return new RespEntity(RespCode.DATA_IMPORT_FAIL, null);
		}

		// 进一步判断文件内容是否为空(即判断其大小是否为0或其名称是否为null)
		long size = file.getSize();
		if (StringUtils.isEmpty(fileName) || size == 0) {
			session.setAttribute("msg", "文件不能为空！");
			return new RespEntity(RespCode.DATA_IMPORT_FAIL, null);
		}

		// 批量导入
		String message = "导入成功";
		// knowledgeService.batchImport(fileName, file, account.getUsername());
		session.setAttribute("msg", message);
		return new RespEntity(RespCode.DATA_IMPORT_SUCCESS, null);
	}
}
