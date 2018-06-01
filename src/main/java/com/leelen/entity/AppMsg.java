/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日上午10:06:20
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

/**
 * @author xiaoxl
 *
 */
public class AppMsg {

	private int code;

	private String msg;

	private Object data;

	/**
	 * 
	 */
	public AppMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param msg
	 * @param data
	 */
	public AppMsg(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public AppMsg returnMsg(int code, String msg, Object data) {
		return new AppMsg(code, msg, data);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
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
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppMsg [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
