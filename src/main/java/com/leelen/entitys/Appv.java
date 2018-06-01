/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:42:57
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author xiaoxl APP版本
 *
 */
@Entity
@Table(name = "appv", schema = "llsmart", catalog = "")
public class Appv {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "appname", nullable = false)
	private String appname;// app名称

	@Basic
	@Column(name = "appvcode", nullable = false)
	private String appvcode;// app版本号

	@Basic
	@Column(name = "appnote", nullable = false)
	private String appnote;// app说明

	@Basic
	@Column(name = "apkurl", nullable = false)
	private String apkurl;// app下载地址

	@Basic
	@Column(name = "uptime", nullable = false)
	private String uptime;// app更新时间

	/**
	 * @return the id
	 */
	@JsonIgnore
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
	 * @return the appname
	 */
	public String getAppname() {
		return appname;
	}

	/**
	 * @param appname
	 *            the appname to set
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
	 * @param appvcode
	 *            the appvcode to set
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
	 * @param appnote
	 *            the appnote to set
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
	 * @param apkurl
	 *            the apkurl to set
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
	 * @param uptime
	 *            the uptime to set
	 */
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Appv [id=" + id + ", appname=" + appname + ", appvcode=" + appvcode + ", appnote=" + appnote
				+ ", apkurl=" + apkurl + ", uptime=" + uptime + "]";
	}

	/**
	 * 
	 */
	public Appv() {
		super();
		// TODO Auto-generated constructor stub
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

}
