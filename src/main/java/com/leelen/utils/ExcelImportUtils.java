/**
 * @包名:com.leelen.utils
 * @描述:TODO
 */
package com.leelen.utils;

/**
 * @author xiaoxl by male
 * @time 2018年6月12日下午5:09:41
 * @class ExcelImportUtils.java
 * 
 *        描述:excel导入数据库
 */
public class ExcelImportUtils {

	// @描述：是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @描述：是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			return false;
		}
		return true;
	}
}
