/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:55:12
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
 * @author xiaoxl 权限表
 *
 */
@Entity
@Table(name = "permission", schema = "llsmart", catalog = "")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "opid", nullable = false)
	private int opid;// 权限标识

	@Basic
	@Column(name = "opcode", nullable = false)
	private String opcode;// 权限值

	@Basic
	@Column(name = "opname", nullable = false)
	private String opname;// 权限名称

	@Basic
	@Column(name = "ophref", nullable = false)
	private String ophref;// 权限操作链接

	@Basic
	@Column(name = "opseq", nullable = false)
	private int opseq;// 显示顺序

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
	 * @return the opcode
	 */
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

	/**
	 * @return the ophref
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Permission [id=" + id + ", opid=" + opid + ", opcode=" + opcode + ", opname=" + opname + ", ophref="
				+ ophref + ", opseq=" + opseq + "]";
	}

	/**
	 * 
	 */
	public Permission() {
		super();
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
	public Permission(int id, int opid, String opcode, String opname, String ophref, int opseq) {
		super();
		this.id = id;
		this.opid = opid;
		this.opcode = opcode;
		this.opname = opname;
		this.ophref = ophref;
		this.opseq = opseq;
	}

}
