/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  ArrayToStr.java   
* @Package com.leelen.publicmethod   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年6月29日 下午3:55:26   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.publicmethod;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: ArrayToStr
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年6月29日 下午3:55:26
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ArrayToStr {

	public static String ArrayConvertStr(Object[] objects) {
		return StringUtils.join(objects, ",");
	}

	public static void main(String[] args) {
		String[] orgStr = { "a", "b", "c", "d", "e", "f" };
		String str1 = StringUtils.join(orgStr, ",");
		// String str2 = String.format("%s,%s,%s", orgStr);
		System.out.println(str1);
	}
}
