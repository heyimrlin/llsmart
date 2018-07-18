/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月26日下午6:41:15
 * @包名:com.leelen.publicmethod
 * @描述:TODO
 */
package com.leelen.publicmethod;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl
 *
 */
public class MyMethod {

	static Logger logger = LoggerFactory.getLogger(MyMethod.class);

	static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat dateFormaterStr = new SimpleDateFormat("yyyyMMddHHmmss");
	static Date date = new Date();

	private static String strSign(String url, String params, long template) {
		String str = url + params;
		return MD5Tools.MD5(str);
	}

	// 判断签名
	public static boolean verdictSign(String StrSign, String sign) {
		String Md5Str = MD5Tools.MD5(StrSign);
		System.out.println("sign:" + Md5Str);
		if (Md5Str.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	// 生成Token
	public static String GetGUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	// 生成Token
	public static String GetGUIDF() {
		return UUID.randomUUID().toString();
	}

	// 生成时间格式为yyyyMMddHHmmss作为生成ID
	public static String getDateStr(Date dat) {
		return dateFormaterStr.format(dat);
	}

	// 生成时间格式为yyyyMMddHHmmss作为生成ID
	public static String getDate() {
		return dateFormater.format(date);
	}

	// 时间戳转日期字符串
	public static String transForDate1(Integer ms) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (ms != null) {
				try {
					str = sdf.format(msl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	/**
	 * 日期字符串转时间戳
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Integer transForMilliSecond(String dateStr) {
		Date date = MyMethod.formatDate(dateStr);
		return date == null ? null : MyMethod.transForMilliSecond(date);
	}

	/**
	 * 日期转时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Integer transForMilliSecond(Date date) {
		if (date == null)
			return null;
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date formatDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 把long 转换成 日期 再转换成String类型 eg:transferLongToDate("yyyy-MM-dd
	 * HH:mm:ss",1245678944);
	 */
	public static String transferLongToDate(String dateFormat, Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	// 生成随机数
	public static String ramdaSw(int num) {

		String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < num; j++) {
			flag.append(sources.charAt(rand.nextInt(9)) + "");
		}
		logger.info(flag.toString());
		return flag.toString();
	}

	// 获取请求IP地址
	/**
	 * 获取当前网络ip
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		logger.info(">>>ip:" + ipAddress);
		return ipAddress;
	}

	/**
	 * 根据名字获取cookie
	 * 
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	// 添加cookie
	public static void addCookie(HttpServletResponse response, String cookieName, Object cookieValue, int MaxAge) {
		Cookie cookie = new Cookie(cookieName, cookieValue.toString().trim());
		cookie.setMaxAge(MaxAge);// cookie时效性:单位-秒
		cookie.setPath("/");
		logger.info("添加的cookie名字为:" + cookieName);
		response.addCookie(cookie);
	}

	// 根据name清除cookie的值
	public static void cleanCookieByName(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		logger.info("被删除的cookie名字为:" + cookieName);
		response.addCookie(cookie);
	}

	public static void main(String[] args) {

		System.out.println(GetGUID());
		// HttpServletRequest request = null;
		// getIpAddr(request);
		// long template = new Date().getTime();
		// System.out.println(strSign("/test",
		// "?uid=001&password=e10adc3949ba59abbe56e057f20f883e", template));
		// System.out.println(GetGUID());
		// System.out.println(dateFormaterStr.format(date));
	}
}
