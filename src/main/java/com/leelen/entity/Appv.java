/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日上午8:48:26
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xiaoxl
 *
 */
@Entity
@Table(name = "appv")
public class Appv {

	@Id
	@GeneratedValue
	private int id;//
	
	@Column(name="appname", nullable = false)
	private String appname;// app名称
	
	@Column(name="appvcode", nullable = false)
	private String appvcode;// app版本
	
	@Column(name="appnote", nullable = false)
	private String appnote;// app更新信息
	
	@Column(name="apkurl", nullable = false)
	private String apkurl;// app下载地址
	
	@Column(name="uptime", nullable = false)
	private String uptime;// 时间

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the appname
	 */
	public String getAppname() {
		return appname;
	}

	/**
	 * @param appname the appname to set
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
	 * @return the appvcode
	 */
	public String getAppvcode() {
		return appvcode;
	}

	/**
	 * @param appvcode the appvcode to set
	 */
	public void setAppvcode(String appvcode) {
		this.appvcode = appvcode;
	}

	/**
	 * @return the appnote
	 */
	public String getAppnote() {
		return appnote;
	}

	/**
	 * @param appnote the appnote to set
	 */
	public void setAppnote(String appnote) {
		this.appnote = appnote;
	}

	/**
	 * @return the apkurl
	 */
	public String getApkurl() {
		return apkurl;
	}

	/**
	 * @param apkurl the apkurl to set
	 */
	public void setApkurl(String apkurl) {
		this.apkurl = apkurl;
	}

	/**
	 * @return the uptime
	 */
	public String getUptime() {
		return uptime;
	}

	/**
	 * @param uptime the uptime to set
	 */
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	/**
	 * @param id
	 * @param appname
	 * @param appvcode
	 * @param appnote
	 * @param apkurl
	 * @param uptime
	 */
	public Appv(int id, String appname, String appvcode, String appnote, String apkurl, String uptime) {
		super();
		this.id = id;
		this.appname = appname;
		this.appvcode = appvcode;
		this.appnote = appnote;
		this.apkurl = apkurl;
		this.uptime = uptime;
	}

	/**
	 * 
	 */
	public Appv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
