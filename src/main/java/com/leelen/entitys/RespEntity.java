/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月10日上午11:36:13
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entitys;

/**
 * @author xiaoxl
 *
 */
public class RespEntity {

	private int code;

	private String msg;

	private Object data;

	public RespEntity(RespCode respCode) {
		this.code = respCode.getCode();
		this.msg = respCode.getMsg();
	}

	public RespEntity(RespCode respCode, Object data) {
		this(respCode);
		this.data = data;
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

}
