/**
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
 * @author xiaoxl by male
 * @time 2018年6月26日下午1:39:00
 * @class Appmenus.java
 */
@Entity
@Table(name = "appmenus", schema = "llsmart", catalog = "")
public class Appmenus implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "opid", nullable = false)
	private String opid;//

	@Basic
	@Column(name = "name", nullable = false)
	private String name;//

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;//

	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPid() {
		return opid;
	}

	public void setPid(String opid) {
		this.opid = opid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Appmenus [id=" + id + ", opid=" + opid + ", name=" + name + ", createtime=" + createtime + "]";
	}

	/**
	 * 
	 */
	public Appmenus() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param pid
	 * @param name
	 * @param createtime
	 */
	public Appmenus(int id, String opid, String name, String createtime) {
		this.id = id;
		this.opid = opid;
		this.name = name;
		this.createtime = createtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((opid == null) ? 0 : opid.hashCode());
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
		Appmenus other = (Appmenus) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (opid == null) {
			if (other.opid != null)
				return false;
		} else if (!opid.equals(other.opid))
			return false;
		return true;
	}

}
