/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:55:12
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
 * @author xiaoxl 权限表
 *
 */
@Entity
@Table(name = "permission", schema = "llsmart", catalog = "")
public class Permission implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "parentid", nullable = false)
	private int parentid;// 父id

	@Basic
	@Column(name = "opid", nullable = false)
	private String opid;// 权限标识

	@Basic
	@Column(name = "opcode", nullable = false)
	private String opcode;// 权限值

	@Basic
	@Column(name = "opname", nullable = false)
	private String opname;// 权限名称optype

	@Basic
	@Column(name = "optype", nullable = false)
	private int optype;// 权限名称

	@Basic
	@Column(name = "ophref", nullable = false)
	private String ophref;// 权限操作链接

	@Basic
	@Column(name = "opseq", nullable = false)
	private int opseq;// 显示顺序

	@Basic
	@Column(name = "describe", nullable = false)
	private String describe;// 描述

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

	@JsonIgnore
	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
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
	 * @return the opcode
	 */
	@JsonIgnore
	public String getOpcode() {
		return opcode;
	}

	/**
	 * @param opcode
	 *            the opcode to set
	 */
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	/**
	 * @return the opname
	 */
	public String getOpname() {
		return opname;
	}

	/**
	 * @param opname
	 *            the opname to set
	 */
	public void setOpname(String opname) {
		this.opname = opname;
	}

	@JsonIgnore
	public int getOptype() {
		return optype;
	}

	public void setOptype(int optype) {
		this.optype = optype;
	}

	/**
	 * @return the ophref
	 */
	@JsonIgnore
	public String getOphref() {
		return ophref;
	}

	/**
	 * @param ophref
	 *            the ophref to set
	 */
	public void setOphref(String ophref) {
		this.ophref = ophref;
	}

	/**
	 * @return the opseq
	 */
	public int getOpseq() {
		return opseq;
	}

	/**
	 * @param opseq
	 *            the opseq to set
	 */
	public void setOpseq(int opseq) {
		this.opseq = opseq;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Permission [id=" + id + ",parentid=" + parentid + ", opid=" + opid + ", opcode=" + opcode + ", opname="
				+ opname + ",optype=" + optype + ", ophref=" + ophref + ", opseq=" + opseq + ",describe=" + describe
				+ "]";
	}

	/**
	 * 
	 */
	public Permission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param opid
	 * @param opcode
	 * @param opname
	 * @param ophref
	 * @param opseq
	 */
	public Permission(int id, int parentid, String opid, String opcode, String opname, int optype, String ophref,
			int opseq, String describe) {
		this.id = id;
		this.parentid = parentid;
		this.opid = opid;
		this.opcode = opcode;
		this.opname = opname;
		this.optype = optype;
		this.ophref = ophref;
		this.opseq = opseq;
		this.describe = describe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + id;
		result = prime * result + ((opcode == null) ? 0 : opcode.hashCode());
		result = prime * result + ((ophref == null) ? 0 : ophref.hashCode());
		result = prime * result + ((opid == null) ? 0 : opid.hashCode());
		result = prime * result + ((opname == null) ? 0 : opname.hashCode());
		result = prime * result + opseq;
		result = prime * result + optype;
		result = prime * result + parentid;
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
		Permission other = (Permission) obj;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (id != other.id)
			return false;
		if (opcode == null) {
			if (other.opcode != null)
				return false;
		} else if (!opcode.equals(other.opcode))
			return false;
		if (ophref == null) {
			if (other.ophref != null)
				return false;
		} else if (!ophref.equals(other.ophref))
			return false;
		if (opid == null) {
			if (other.opid != null)
				return false;
		} else if (!opid.equals(other.opid))
			return false;
		if (opname == null) {
			if (other.opname != null)
				return false;
		} else if (!opname.equals(other.opname))
			return false;
		if (opseq != other.opseq)
			return false;
		if (optype != other.optype)
			return false;
		if (parentid != other.parentid)
			return false;
		return true;
	}

}
