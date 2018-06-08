/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月10日上午11:36:34
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entitys;

/**
 * @author xiaoxl
 *
 */
public enum RespCode {

	SUCCESS(0, "请求成功"), WARN(-1, "网络异常，请稍后重试")
	, TOKEN_ERROR(4001, "Token无效、错误")
	, TOKEN_INVALID(4002, "Token失效")
	, SIGN_ERROR(4003, "Sign签名错误")
	, MISSING_PARAMETER(4004, "缺少参数")
	, PARAMETER_ERROR(4005, "参数错误")
	, INVALID_REQUEST(4006, "无效请求")
	, ILLEGAL_REQUEST(4007, "不合法的请求格式")
	, INTERFACE_STOP(4008, "接口已停用")
	, SYSTEM_MAINTENANCE(4009, "系统维护")
	, ACCOUNT_INEXISTENCE(4100, "账号不存在(错误)")
	, PASSWORD_ERROR(4101, "密码错误")
	, ACCOUNT_IN_OTHER_LOGIN(4102, "账号已在其它设备登录")
	, DATEFORMAT_ERROR(4103, "日期格式错误")
	, FAIL_UPLOAD(4104, "上传失败")
	, DATE_SCOPE_ERROR(4105, "时间范围不合法")
	, MUNST_GET(4106, "需要 GET 请求")
	, MUNST_POST(4107, "需要 POST 请求")
	, REQUEST_FREQUENTLY(4108, "请求太频繁，请稍候再试")
	, PLOT_INEXISTENCE_UNIT(4200, "不存在此小区对应的楼幢、单元")
	, UNIT_INEXISTENCE_ROOM(4201, "不存在此楼幢、单元对应的房间")
	, COMMAND_FAIL(4202, "口令生成失败")
	, OLD_PASWORD_ERROR(4203, "原密码错误")
	, TELL_REGISTER(4204, "该号码已被注册")
	, TELL_NOTREGISTER(4205, "用户名或密码错误")
	, MODIFY_ERROR(4206, "修改失败 ")
	, MODIFY_SUCCESS(0, "修改成功 ")
	, PLATFORM_NO_USER(4207, "平台未配置该用户 ");

	private int code;
	private String msg;

	RespCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
