/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午5:23:58
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
 * @author xiaoxl 角色表
 *
 */
@Entity
@Table(name = "role", schema = "llsmart", catalog = "")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "roleid", nullable = false)
	private String roleid;// 角色ID，唯一标识

	@Basic
	@Column(name = "rolename", nullable = false)
	private String rolename;// 角色名

	@Basic
	@Column(name = "cname", nullable = false)
	private String cname;// 中文名

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
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename
	 *            the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname
	 *            the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleid=" + roleid + ", rolename=" + rolename + ", cname=" + cname + "]";
	}

	/**
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param roleid
	 * @param rolename
	 * @param cname
	 */
	public Role(int id, String roleid, String rolename, String cname) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.rolename = rolename;
		this.cname = cname;
	}

}
