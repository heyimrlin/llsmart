/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日上午9:57:07
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

/**
 * @author xiaoxl
 *
 */
public class PublicMsg {

	
	private int code;
	
	private String msg;
	
	private Object data;

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
	 * @return the entity
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @param code
	 * @param msg
	 * @param entity
	 */
	public PublicMsg(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 
	 */
	public PublicMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PublicMsg returnDatas(int code, String msg, Object data) {
		return new PublicMsg(code, msg, data);
	}
	
}
