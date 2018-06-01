package com.leelen.sys.config;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import org.apache.log4j.Logger;

public final class Config {

	private static ResourceBundle MY_Resource;

	private static boolean OpenData = true;

	/*
	 * 平台标识
	 */
	public static String Leelen;

	/**
	 * 是否开启Action
	 */
	public static boolean OpenAction = true;

	/**
	 * 程序所在目录
	 */
	public static String PackagePath;

	public static String Web_Path;
	/**
	 * 服务器URL
	 */
	public static String URL = "";
	/**
	 * 包名
	 */
	public static String PackageName;
	/**
	 * 项目名
	 */
	public static String ProjectName;
	/**
	 * action 扩展名
	 */
	public static String Extension;
	/**
	 * 是否开启Sms
	 */
	public static boolean Sms = false;
	/**
	 * 短信通道帐号
	 */
	public static String Sms_UserName = "";
	/**
	 * 短信通道密码
	 */
	public static String Sms_Password = "";
	/**
	 * 短信通道密钥
	 */
	public static String Sms_Key = "";
	/**
	 * 项目配置
	 */
	public static String ProjectConfig = null;
	/**
	 * 用户组
	 */
	public static Map<String, String> User_Group = new HashMap<String, String>();

	/**
	 * 系统邮箱
	 */
	public static String System_Email = null;
	/**
	 * 注册的Action,用检索权限ID
	 */
	public static Map<String, Integer> Map_Actions = new HashMap<String, Integer>();
	/**
	 * 系统注册的Action
	 */
	public static Action[] Actions = null;
	/**
	 * Action分组信息
	 */
	public static String[] Action_Groups = null;
	/**
	 * 平台编号及密钥
	 */
	public static Map<String, String> KeyMap;

	/**
	 * 是否开启Wiki
	 */
	public static boolean OpenWiki = true;
	/***
	 * 是否打开Session功能
	 */
	public static boolean OpenSession = true;

	/***
	 * 是否打开短信接口
	 */
	public static boolean OpenTelSession = true;
	/***
	 * 日记输出
	 */
	public static Logger LogWrite;
	/***
	 * 验证码间隔发送时间
	 */
	public static int TelSend = 60;
	/***
	 * 图片验证码保持时间
	 */
	public static long ImageOverTime = 600000;

	/***
	 * 开启调试日记(不输出错误日记)
	 */
	public static boolean Log_Flag = true;

	/**
	 * 记录目前服务器Session文件信息
	 */
	public static Map<String, String> Session_Files = new HashMap<String, String>();

	public static String GetGUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
