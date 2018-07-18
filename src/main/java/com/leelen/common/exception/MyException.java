/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  MyException.java   
* @Package com.leelen.common.exception   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月2日 下午2:37:54   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.common.exception;

/**
 * @ClassName: MyException
 * @Description:TODO
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月2日 下午2:37:54
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MyException extends Exception {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {

		super(message);
	}
}
