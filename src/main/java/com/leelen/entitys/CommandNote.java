/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:58:44
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
 * @author xiaoxl 口令产生记录
 *
 */
@Entity
@Table(name = "commandnote", schema = "llsmart", catalog = "")
public class CommandNote implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((createid == null) ? 0 : createid.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + id;
		result = prime * result + isuse;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((validtime == null) ? 0 : validtime.hashCode());
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
		CommandNote other = (CommandNote) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (createid == null) {
			if (other.createid != null)
				return false;
		} else if (!createid.equals(other.createid))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id != other.id)
			return false;
		if (isuse != other.isuse)
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (validtime == null) {
			if (other.validtime != null)
				return false;
		} else if (!validtime.equals(other.validtime))
			return false;
		return true;
	}

}
