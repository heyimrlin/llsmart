/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:42:57
 * @包名:com.leelen.entitys
 * @描述:TODO
 */
package com.leelen.entitys;

import java.io.Serializable;

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
public class Appv implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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
		this.id = id;
		this.appname = appname;
		this.appvcode = appvcode;
		this.appnote = appnote;
		this.apkurl = apkurl;
		this.uptime = uptime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apkurl == null) ? 0 : apkurl.hashCode());
		result = prime * result + ((appname == null) ? 0 : appname.hashCode());
		result = prime * result + ((appnote == null) ? 0 : appnote.hashCode());
		result = prime * result + ((appvcode == null) ? 0 : appvcode.hashCode());
		result = prime * result + id;
		result = prime * result + ((uptime == null) ? 0 : uptime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appv other = (Appv) obj;
		if (apkurl == null) {
			if (other.apkurl != null)
				return false;
		} else if (!apkurl.equals(other.apkurl))
			return false;
		if (appname == null) {
			if (other.appname != null)
				return false;
		} else if (!appname.equals(other.appname))
			return false;
		if (appnote == null) {
			if (other.appnote != null)
				return false;
		} else if (!appnote.equals(other.appnote))
			return false;
		if (appvcode == null) {
			if (other.appvcode != null)
				return false;
		} else if (!appvcode.equals(other.appvcode))
			return false;
		if (id != other.id)
			return false;
		if (uptime == null) {
			if (other.uptime != null)
				return false;
		} else if (!uptime.equals(other.uptime))
			return false;
		return true;
	}

}
