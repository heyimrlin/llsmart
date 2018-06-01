/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:46:15
 * @包名:com.leelen.entitys
 * @描述:TODO
 */
package com.leelen.entitys;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xiaoxl 操作日志
 *
 */
@Entity
@Table(name = "olog", schema = "llsmart", catalog = "")
public class OperationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "username", nullable = false)
	private String username;// 操作用户名称

	@Basic
	@Column(name = "type", nullable = false)
	private int type;// 操作类型

	@Basic
	@Column(name = "url", nullable = false)
	private String url;// 请求地址

	@Basic
	@Column(name = "method", nullable = false)
	private String method;// 请求方法

	@Basic
	@Column(name = "params", nullable = false)
	private String params;// 请求参数

	@Basic
	@Column(name = "requestip", nullable = false)
	private String requestip;// 请求IP

	@Basic
	@Column(name = "description", nullable = false)
	private String description;// 操作描述

	@Basic
	@Column(name = "detail", nullable = false)
	private String detail;// 详情

	@Basic
	@Column(name = "oper_date", nullable = false)
	private String oper_date;// 操作时间

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @return the requestip
	 */
	public String getRequestip() {
		return requestip;
	}

	/**
	 * @param requestip
	 *            the requestip to set
	 */
	public void setRequestip(String requestip) {
		this.requestip = requestip;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the oper_date
	 */
	public String getOper_date() {
		return oper_date;
	}

	/**
	 * @param oper_date
	 *            the oper_date to set
	 */
	public void setOper_date(String oper_date) {
		this.oper_date = oper_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OperationLog [id=" + id + ", username=" + username + ", type=" + type + ", url=" + url + ", method="
				+ method + ", params=" + params + ", requestip=" + requestip + ", description=" + description
				+ ", detail=" + detail + ", oper_date=" + oper_date + "]";
	}

	/**
	 * 
	 */
	public OperationLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param username
	 * @param type
	 * @param url
	 * @param method
	 * @param params
	 * @param requestip
	 * @param description
	 * @param detail
	 * @param oper_date
	 */
	public OperationLog(int id, String username, int type, String url, String method, String params, String requestip,
			String description, String detail, String oper_date) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
		this.url = url;
		this.method = method;
		this.params = params;
		this.requestip = requestip;
		this.description = description;
		this.detail = detail;
		this.oper_date = oper_date;
	}

}
