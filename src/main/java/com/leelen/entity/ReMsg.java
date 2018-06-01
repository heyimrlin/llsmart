/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日下午6:21:24
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.util.Map;

/**
 * @author xiaoxl
 *
 */
public class ReMsg {

	private int code;
	
	private String msg;
	
	private Map<String, Object> data;
	
	public ReMsg reMsg(int code, String msg, Map<String, Object> data) {
		return reMsg(code, msg, data);
	}

	/**
	 * 
	 */
	public ReMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param msg
	 * @param data
	 */
	public ReMsg(int code, String msg, Map<String, Object> data) {
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
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	
}
