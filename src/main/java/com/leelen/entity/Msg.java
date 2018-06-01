/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午4:44:36
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.util.List;

/**
 * @author xiaoxl
 * @param <T>
 * @param <E>
 *
 */
public class Msg<T, E> {

	private int code;
	private String msg;
	
	private List<Object> data;
	
	private List<User> datas;
	
	private int account;

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
	public List<Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<Object> data) {
		this.data = data;
	}

	
	
	
	/**
	 * @return the account
	 */
	public int getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(int account) {
		this.account = account;
	}
	
	
	
	
	

	/**
	 * @return the datas
	 */
	public List<User> getDatas() {
		return datas;
	}

	/**
	 * @param users the datas to set
	 */
	public void setDatas(List<User> users) {
		this.datas = users;
	}

	/**
	 * @param code
	 * @param msg
	 * @param data
	 */
	public Msg(int code, String msg, List<Object> data, int account) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.account = account;
	}

	/**
	 * 
	 */
	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
