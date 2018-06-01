/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:58:44
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
 * @author xiaoxl 口令产生记录
 *
 */
@Entity
@Table(name = "commandnote", schema = "llsmart", catalog = "")
public class CommandNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "uid", nullable = false, length = 30)
	private String uid;// 用户ID，唯一标识

	@Basic
	@Column(name = "createid", nullable = false)
	private String createid;// 口令产生ID

	@Basic
	@Column(name = "unit", nullable = false)
	private String unit;// 单元 注:口令根据单元生成口令，不是按设备生成

	@Basic
	@Column(name = "command", nullable = false)
	private String command;// 口令，唯一标识

	@Basic
	@Column(name = "isuse", nullable = false)
	private int isuse;// 标识口令是否已使用

	@Basic
	@Column(name = "validtime", nullable = false)
	private String validtime;// 有效时间

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 口令生成时间

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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the createid
	 */
	public String getCreateid() {
		return createid;
	}

	/**
	 * @param createid
	 *            the createid to set
	 */
	public void setCreateid(String createid) {
		this.createid = createid;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
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

	/**
	 * @return the validtime
	 */
	public String getValidtime() {
		return validtime;
	}

	/**
	 * @param validtime
	 *            the validtime to set
	 */
	public void setValidtime(String validtime) {
		this.validtime = validtime;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommandNote [id=" + id + ", uid=" + uid + ", createid=" + createid + ", unit=" + unit + ", command="
				+ command + ", isuse=" + isuse + ", validtime=" + validtime + ", createtime=" + createtime + "]";
	}

	/**
	 * 
	 */
	public CommandNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param createid
	 * @param unit
	 * @param command
	 * @param isuse
	 * @param validtime
	 * @param createtime
	 */
	public CommandNote(int id, String uid, String createid, String unit, String command, int isuse, String validtime,
			String createtime) {
		super();
		this.id = id;
		this.uid = uid;
		this.createid = createid;
		this.unit = unit;
		this.command = command;
		this.isuse = isuse;
		this.validtime = validtime;
		this.createtime = createtime;
	}

}
