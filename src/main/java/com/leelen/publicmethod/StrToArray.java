/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  StrToArray.java   
* @Package com.leelen.publicmethod   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年6月29日 下午3:55:13   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.publicmethod;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: StrToArray
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年6月29日 下午3:55:13
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class StrToArray {

	public static String[] strConvertArray(String strSplit) {
		String[] resultArray = strSplit.split(",");
		return resultArray;
	}

	public static void main(String[] args) {
		String orgStr = "a,b,c,d,e,f";
		String[] result1 = strConvertArray(orgStr);
		for (int a = 0; a < result1.length; a++) {
			System.out.print(result1[a] + "");
			if (result1[a].equals("f")) {
				System.out.println("\n您拥有该权限f");
			}
		}

		String str1 = StringUtils.join(result1, ",");
		// String str2 = String.format("%s,%s,%s", result1);
		System.out.println("\n" + str1);
	}
}
