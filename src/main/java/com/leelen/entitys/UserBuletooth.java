/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:31:34
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
 * @author xiaoxl
 *
 */
@Entity
@Table(name = "userbuletooth", schema = "llsmart", catalog = "")
public class UserBuletooth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "buletoothid", nullable = false)
	private String buletoothid;// 蓝牙编号

	@Basic
	@Column(name = "buletoothaddress", nullable = false)
	private String buletoothaddress;// 蓝牙mac

	@Basic
	@Column(name = "buletoothname", nullable = false)
	private String buletoothname;// 蓝牙名称

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
	 * @return the buletoothid
	 */
	public String getBuletoothid() {
		return buletoothid;
	}

	/**
	 * @param buletoothid
	 *            the buletoothid to set
	 */
	public void setBuletoothid(String buletoothid) {
		this.buletoothid = buletoothid;
	}

	/**
	 * @return the buletoothaddress
	 */
	public String getBuletoothaddress() {
		return buletoothaddress;
	}

	/**
	 * @param buletoothaddress
	 *            the buletoothaddress to set
	 */
	public void setBuletoothaddress(String buletoothaddress) {
		this.buletoothaddress = buletoothaddress;
	}

	/**
	 * @return the buletoothname
	 */
	public String getBuletoothname() {
		return buletoothname;
	}

	/**
	 * @param buletoothname
	 *            the buletoothname to set
	 */
	public void setBuletoothname(String buletoothname) {
		this.buletoothname = buletoothname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBuletooth [id=" + id + ", buletoothid=" + buletoothid + ", buletoothaddress=" + buletoothaddress
				+ ", buletoothname=" + buletoothname + "]";
	}

	/**
	 * 
	 */
	public UserBuletooth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param buletoothid
	 * @param buletoothaddress
	 * @param buletoothname
	 */
	public UserBuletooth(int id, String buletoothid, String buletoothaddress, String buletoothname) {
		super();
		this.id = id;
		this.buletoothid = buletoothid;
		this.buletoothaddress = buletoothaddress;
		this.buletoothname = buletoothname;
	}

}
