/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:25:02
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
 * @author xiaoxl 系统配置
 *
 */
@Entity
@Table(name = "systeminfo", schema = "llsmart", catalog = "")
public class SystemInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "jian", nullable = false)
	private String jian;// 键

	@Basic
	@Column(name = "zhi", nullable = false)
	private String zhi;// 键

	@Basic
	@Column(name = "roleid", nullable = false)
	private String roleid;// 键

	@Basic
	@Column(name = "otime", nullable = false)
	private String otime;// 键

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
	 * @return the jian
	 */
	public String getJian() {
		return jian;
	}

	/**
	 * @param jian
	 *            the jian to set
	 */
	public void setJian(String jian) {
		this.jian = jian;
	}

	/**
	 * @return the zhi
	 */
	public String getZhi() {
		return zhi;
	}

	/**
	 * @param zhi
	 *            the zhi to set
	 */
	public void setZhi(String zhi) {
		this.zhi = zhi;
	}

	/**
	 * @return the roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid
	 *            the roleid to set
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the otime
	 */
	public String getOtime() {
		return otime;
	}

	/**
	 * @param otime
	 *            the otime to set
	 */
	public void setOtime(String otime) {
		this.otime = otime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemInfo [id=" + id + ", jian=" + jian + ", zhi=" + zhi + ", roleid=" + roleid + ", otime=" + otime
				+ "]";
	}

	/**
	 * 
	 */
	public SystemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param jian
	 * @param zhi
	 * @param roleid
	 * @param otime
	 */
	public SystemInfo(int id, String jian, String zhi, String roleid, String otime) {
		super();
		this.id = id;
		this.jian = jian;
		this.zhi = zhi;
		this.roleid = roleid;
		this.otime = otime;
	}

}
