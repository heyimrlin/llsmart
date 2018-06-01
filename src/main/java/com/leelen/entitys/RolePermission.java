/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:20:52
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
@Table(name = "role_permission", schema = "llsmart", catalog = "")
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "roleid", nullable = false)
	private String roleid;// 角色ID，唯一标识

	@Basic
	@Column(name = "opid", nullable = false)
	private int opid;// 权限ID

	@Basic
	@Column(name = "isuse", nullable = false)
	private int isuse;// 是否可用

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
	 * @return the opid
	 */
	public int getOpid() {
		return opid;
	}

	/**
	 * @param opid
	 *            the opid to set
	 */
	public void setOpid(int opid) {
		this.opid = opid;
	}

	/**
	 * @return the isuse
	 */
	public int getIsuse() {
		return isuse;
	}

	/**
	 * @param isuse
	 *            the isuse to set
	 */
	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleid=" + roleid + ", opid=" + opid + ", isuse=" + isuse + "]";
	}

	/**
	 * 
	 */
	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param roleid
	 * @param opid
	 * @param isuse
	 */
	public RolePermission(int id, String roleid, int opid, int isuse) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.opid = opid;
		this.isuse = isuse;
	}

}
