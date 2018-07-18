/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  Command.java   
* @Package com.leelen.command   
* @Description:    TODO口令生成  
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月5日 下午8:07:13   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Command
 * @Description:TODO口令生成
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月5日 下午8:07:13
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Command {

	private String[] ids = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	private String[] abc = { "a", "b", "c", "d", "e", "f" };

	/**
	 * @Title: ${enclosing_method} @Description: ${todo} 获取口令 @param:
	 *         deviceID设备id @param: datetime时间 @param: key密钥 @return:
	 *         ${return_type} @throws
	 */

	public static Map<String, Object> getCommand(String deviceID, String datetime, String key) {
		String commandStr = deviceID + datetime + key;
		System.out.println(commandStr);// 20+13+8
		// 倒序
		StringBuilder sBuilder = new StringBuilder();
		for (int i = commandStr.replace("93leelen", "").length() - 1; i >= 0; i--) {
			sBuilder.append(commandStr.charAt(i));
		}
		String strCommand = sBuilder.toString().toLowerCase();
		System.out.println(strCommand);
		// 重新分组
		String[] reCommandStr = new String[3];
		for (int i = 0; i < strCommand.length(); i++) {

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("command", strCommand);
		return map;
	}

	public static void main(String[] args) {
		getCommand("34230000000000010001", "1530781868696", "93leelen");

		// 10进制转16进制
		Integer x = 342300;
		String hex = x.toHexString(x);
		System.out.println(hex);

		// 16进制转10进制
		String hexT = "5391c";
		Integer xT = Integer.parseInt(hexT, 16);
		System.out.println(xT);

		String hexs = "0xfff";
		Integer xs = Integer.parseInt(hexs.substring(2), 16);// 从第2个字符开始截取
		System.out.println(xs);
	}
}
