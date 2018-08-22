/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leelen.app.service.MoblieUserService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.MoblieUser;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年6月12日下午4:15:50
 * @class ExportController.java
 */
@LeelenRestController(msg = "数据导出")
@RequestMapping("/sys/export")
@Api(value = "Export-API", description = "数据导出接口")
public class ExportController {

	@Resource
	MoblieUserService moblieUserService;

	@Log("数据导出excel")
	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	@ApiOperation(value = "数据导出Excel表格", notes = "根据要求将数据导出到Excel表格中")
	@ApiResponse(code = 200, message = "数据导出成功")
	public RespEntity exportExcel(HttpServletResponse response) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("信息表");

		List<MoblieUser> moblieUsers = moblieUserService.getMoblieUser();

		String fileName = "userinf" + ".xls";// 设置要导出的文件的名字
		// 新增数据行，并且设置单元格数据

		int rowNum = 1;

		String[] headers = { "用户ID", "手机号", "登录ip", "注册时间" };
		// headers表示excel表中第一行的表头

		HSSFRow row = sheet.createRow(0);
		// 在excel表中添加表头

		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 在表中存放查询到的数据放入对应的列
		for (MoblieUser moblieUser : moblieUsers) {
			HSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell(0).setCellValue(moblieUser.getUid());
			row1.createCell(1).setCellValue(moblieUser.getTell());
			row1.createCell(2).setCellValue(moblieUser.getLoginip());
			row1.createCell(3).setCellValue(moblieUser.getRegistertime());
			rowNum++;
		}

		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
		return new RespEntity(RespCode.DATA_EXPORT_SUCCESS, null);
	}
}
