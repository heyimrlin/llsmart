/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  GlobalExceptionHandler.java   
* @Package com.leelen.common.exception   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月2日 下午2:38:29   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.entitys.ErrorInfo;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月2日 下午2:38:29
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
