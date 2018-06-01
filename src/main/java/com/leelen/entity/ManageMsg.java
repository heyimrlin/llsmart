/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月9日下午1:58:15
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.util.Map;

/**
 * @author xiaoxl
 *
 */
public class ManageMsg {

	private int code;
	
	private String msg;
	
	private Map<String, Object> data;

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
	
	public ManageMsg returnData(int code, String msg, Map<String, Object> map) {
		ManageMsg manageMsg = new ManageMsg();
		manageMsg.setCode(code);
		manageMsg.setMsg(msg);
		manageMsg.setData(map);
		return manageMsg;
	}
	
	
	public ManageMsg ok(String msg, Map<String, Object> map) {
		ManageMsg manageMsg = new ManageMsg();
		manageMsg.setCode(0);
		manageMsg.setMsg(msg);
		manageMsg.setData(map);
		return manageMsg;
	}
	
	public ManageMsg error(int code, String msg) {
		ManageMsg manageMsg = new ManageMsg();
		manageMsg.setCode(code);
		manageMsg.setMsg(msg);
		manageMsg.setData(null);
		return manageMsg;
	}
	
}
