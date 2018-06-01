/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午4:06:46
 * @包名:com.leelen.utils
 * @描述:TODO
 */
package com.leelen.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.leelen.entitys.Administrator;

/**
 * @author xiaoxl 管理当前当前登录对象
 */
public class CurrentUserUtils {

	private final String CUR_USER = "cur_user";
	public static CurrentUserUtils INSTANCE = null;

	private CurrentUserUtils() {

	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static CurrentUserUtils getInstance() {
		if (INSTANCE == null) {
			synchronized (CurrentUserUtils.class) {
				if (INSTANCE == null) {
					INSTANCE = new CurrentUserUtils();
				}
			}
		}

		return INSTANCE;
	}

	/**
	 * 获取当前Request
	 * 
	 * @return
	 */
	private HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return requestAttributes.getRequest();
	}

	/**
	 * 获取当前Session
	 * 
	 * @return
	 */
	private HttpSession getSession() {
		return getRequest().getSession(true);
	}

	/**
	 * 获取当前session里面放置的User对象
	 * 
	 * @return
	 */
	public Administrator getUser() {
		return (Administrator) getSession().getAttribute(CUR_USER);
	}

	/**
	 * 把当前User对象放置到session里面
	 * 
	 * @param user
	 */
	public void serUser(Administrator administrator) {
		getSession().setAttribute(CUR_USER, administrator);
	}
}
