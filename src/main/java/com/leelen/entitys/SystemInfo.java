/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:25:02
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

/**
 * @author xiaoxl 系统配置
 *
 */
@Entity
@Table(name = "systeminfo", schema = "llsmart", catalog = "")
public class SystemInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((jian == null) ? 0 : jian.hashCode());
		result = prime * result + ((otime == null) ? 0 : otime.hashCode());
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		result = prime * result + ((zhi == null) ? 0 : zhi.hashCode());
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
		SystemInfo other = (SystemInfo) obj;
		if (id != other.id)
			return false;
		if (jian == null) {
			if (other.jian != null)
				return false;
		} else if (!jian.equals(other.jian))
			return false;
		if (otime == null) {
			if (other.otime != null)
				return false;
		} else if (!otime.equals(other.otime))
			return false;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		if (zhi == null) {
			if (other.zhi != null)
				return false;
		} else if (!zhi.equals(other.zhi))
			return false;
		return true;
	}

}
