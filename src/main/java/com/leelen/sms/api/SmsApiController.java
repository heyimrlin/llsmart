/**
 * @包名:com.leelen.sms.api
 * @描述:TODO
 */
package com.leelen.sms.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Leelen;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.Ramdata;

/**
 * @author xiaoxl by male
 * @time 2018年6月14日下午2:32:09
 * @class SmsApiController.java
 */
@LeelenRestController
@RequestMapping("/app/sms")
@EnableConfigurationProperties(Leelen.class)
public class SmsApiController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired // 自动注入，可以直接省略掉set和get，它会帮我们set和get
	Leelen leelen;

	@Value("${leelen.smskey}")
	private String smskey;

	@Value("${leelen.syskey}")
	private String syskey;

	@Log("短信接口")
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public RespEntity smsApi(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "tell") String tell, @RequestParam(value = "key") String key,
			@RequestParam(value = "purpose") String purpose) {
		if (!key.equals(syskey)) {
			return new RespEntity(RespCode.SYS_KEY_ERROR, null);
		}
		String code = Ramdata.ramdaSw(6);
		logger.info(tell + "获取验证码:" + code);
		String responseText = JavaSmsApi.singleSend(smskey, JavaSmsApi.getText(code, 10), tell);
		JSONObject json = JSONObject.parseObject(responseText);
		logger.info("解析:" + json.getString("code") + json.getString("msg"));
		MyMethod.addCookie(response, "code", code, 10 * 60);
		// Cookie cookie = new Cookie("code", code.trim());
		// cookie.setMaxAge(10 * 60);// 设置为10min
		// cookie.setPath("/");
		// logger.info("已添加===============");
		// response.addCookie(cookie);
		if (Integer.parseInt(json.getString("code")) != 0) {
			return new RespEntity(RespCode.SMS_SEND_FAIL, null);
		}
		return new RespEntity(RespCode.SMS_SEND_SUCCESS, null);
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

}
