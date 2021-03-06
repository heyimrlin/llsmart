package com.leelen.msg.config;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author 肖杏林
 * @date 2016年11月21日 上午11:06:13
 * @param cn.xxldata.Configs
 * @Company
 */
public class ApiConfigs {

	public boolean ok = true;

	public static final String SUCCESS_CODE = "10001";// 请求成功
	public static final String SUCCESS_STATE = "SUCCESS";// 返回成功状态信息

	public static final String OUTTIME_CODE = "10002";// 请求超时
	public static final String SERVICE_OUTTIME_INFO = "请求超时";

	public static final String ERROR_CODE = "10004";// 请求失败
	public static final String FAIL_STATE = "ERROR";// 返回失败状态信息

	public static final String INTERFACE_STOP_CODE = "10005";// 接口停用或已更改
	public static final String INTERFACE_ERROR = "接口停用或已更改";

	public static final String LOSSDATA_CODE = "10006";// 缺少必要参数
	public static final String LOSSDATA_TIP = "缺少必要参数";

	public static final String SIGN_ERROR_CODE = "10007";// Sign错误
	public static final String SIGN_ERROR_INFO = "签名错误";

	public static final String APPKEY_ERROR_CODE = "10008";// Sign错误
	public static final String APPKEY_ERROR_INFO = "APPKEY错误";

	public static final String USER_TOKEN_CODE = "";// Token验证
	public static final String USER_TOKEN_INFO = "";//

	// 0接口已删除或接口停用或已更改 1接口正常使用 2接口暂停或系统更新 3系统维护 4服务器出错啦
	public static final String SERVICE_CODE = "10003";// 服务器出错啦
	public static final String SERVICE_STOP = "服务器出错啦";

	public static final String INTERFACE_ERROR_CODE = "10009";// 接口已删除或接口停用或已更改
	public static final String INTERFACE_ERROR_TIP = "接口已删除或接口停用或已更改";

	public static final String INTERFACE_PAUSE_CODE = "10010";// 接口已删除或接口停用或已更改
	public static final String INTERFACE_PAUSE_TIP = "接口暂停或系统更新";

	public static final String SYSTEM_MODIFY_CODE = "10011";// 系统维护
	public static final String SYSTEM_MODIFY_TIP = "接口暂停或系统更新";

	public static String returnDatas(String code, String msg, String state, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("msg", msg);
		map.put("code", code);
		map.put("datas", data);
		// JSON.toJSONString(map);
		return JSON.toJSONString(map).toString();
	}
}
