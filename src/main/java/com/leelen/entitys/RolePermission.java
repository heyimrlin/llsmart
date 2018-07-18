/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:20:52
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
 * @author xiaoxl
 *
 */
@Entity
@Table(name = "role_permission", schema = "llsmart", catalog = "")
public class RolePermission implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "roleid", nullable = false)
	private String roleid;// 角色ID，唯一标识

	@Basic
	@Column(name = "opid", nullable = false)
	private String opid;// 权限ID

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
	public String getOpid() {
		return opid;
	}

	/**
	 * @param opid
	 *            the opid to set
	 */
	public void setOpid(String opid) {
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
	public RolePermission(int id, String roleid, String opid, int isuse) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.opid = opid;
		this.isuse = isuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + isuse;
		result = prime * result + ((opid == null) ? 0 : opid.hashCode());
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
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
		RolePermission other = (RolePermission) obj;
		if (id != other.id)
			return false;
		if (isuse != other.isuse)
			return false;
		if (opid == null) {
			if (other.opid != null)
				return false;
		} else if (!opid.equals(other.opid))
			return false;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		return true;
	}

}
