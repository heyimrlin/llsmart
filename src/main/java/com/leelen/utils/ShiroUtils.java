package com.leelen.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.leelen.entity.AdminUser;

public class ShiroUtils {
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	public static AdminUser getUser() {
		return (AdminUser)getSubjct().getPrincipal();
	}
	public static Long getUserId() {
		return getUser().getId();
	}
	public static void logout() {
		getSubjct().logout();
	}
}
