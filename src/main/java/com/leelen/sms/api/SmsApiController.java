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

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestHeader;
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
import com.leelen.utils.MD5Tools;
import com.leelen.utils.Ramdata;

/**
 * @author xiaoxl by male
 * @time 2018年6月14日下午2:32:09
 * @class SmsApiController.java
 */
@LeelenRestController
@RequestMapping("/app/sms")
@EnableConfigurationProperties(Leelen.class)
@Api(value = "SmsAPI", description = "短信接口")
public class SmsApiController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired // 自动注入，可以直接省略掉set和get，它会帮我们set和get
	Leelen leelen;

	@Value("${leelen.smskey}")
	private String smskey;

	@Value("${leelen.syskey}")
	private String syskey;

	@Log("短信接口")
	@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "获取短信验证码")
	@ApiImplicitParams({@ApiImplicitParam(name = "tell", value = "手机号", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "key", value = "秘钥", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "purpose", value = "意图", paramType = "form", dataType = "integer", required = false),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String",required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true)})
	@ApiResponse(code = 200, message = "获取短信验证码成功")
	public RespEntity smsApi(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "tell") String tell, @RequestHeader(value = "key") String key,
			@RequestParam(value = "purpose") int purpose, @RequestHeader(value = "sign") String sign,
			@RequestHeader(value = "timestamp") long timestamp) {
		// 签名匹配
		String StrSign = "/app/sms/api?tell=" + tell + "&key=" + key + "&timestamp=" + timestamp;
		logger.info("StrSign:" + StrSign);
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		// 时间判定
		if (!MyMethod.checkTimestamp(timestamp, System.currentTimeMillis())) {
			return new RespEntity(RespCode.INVALID_REQUEST, null);
		}
		// 获取短信验证码目的
		// if(!purpose.equals("register")||purpose.equals("modifypwd")||purpose.equals("resetpwd")){
		// return new RespEntity(RespCode.PARAMETER_ERROR, null);
		// }
		// 平台密钥
		if (!key.equals(MD5Tools.MD5(syskey))) {
			return new RespEntity(RespCode.SYS_KEY_ERROR, null);
		}

		// 重新获取短信验证码前删除以前的验证码
		Cookie cookie = new Cookie("code", getCookieByName(request, "code").getValue());
		cookie.setMaxAge(0);
		cookie.setPath("/");
		System.out.println("被删除的cookie名字为:" + cookie.getName());
		response.addCookie(cookie);

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
