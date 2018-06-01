/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月26日下午2:32:28
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xiaoxl
 *
 */
public class ApiMsg {

	private int code;
	
	private String msg;
	
	private JSONObject data;
	
	/**
	 * 
	 */
	public ApiMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param msg
	 * @param data
	 */
	public ApiMsg(int code, String msg, JSONObject data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public JSONObject getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(JSONObject data) {
		this.data = data;
	}
	
	
	public ApiMsg returnDatas(int code, String msg, JSONObject data) {
		
		return new ApiMsg(code, msg, data);
	}
	
	
}
