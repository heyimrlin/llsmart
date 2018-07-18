/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午5:17:54
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
 * @author xiaoxl 小区子账号分配表
 *
 */
@Entity
@Table(name = "plototherhost", schema = "llsmart", catalog = "")
public class PlotOtherHost implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "usehost", nullable = false)
	private String usehost;// (子)账号

	@Basic
	@Column(name = "pwd", nullable = false)
	private String pwd;// 子账号密码

	@Basic
	@Column(name = "isallot", nullable = false)
	private int isallot;// 是否已分配

	@Basic
	@Column(name = "whocreate", nullable = false)
	private String whocreate;// 子账号建立者

	@Basic
	@Column(name = "username", nullable = false)
	private String username;// 使用者

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 创建时间

	@Basic
	@Column(name = "isuse", nullable = false)
	private int isuse;// 是否失效

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
	 * @return the usehost
	 */
	public String getUsehost() {
		return usehost;
	}

	/**
	 * @param usehost
	 *            the usehost to set
	 */
	public void setUsehost(String usehost) {
		this.usehost = usehost;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the isallot
	 */
	public int getIsallot() {
		return isallot;
	}

	/**
	 * @param isallot
	 *            the isallot to set
	 */
	public void setIsallot(int isallot) {
		this.isallot = isallot;
	}

	/**
	 * @return the whocreate
	 */
	public String getWhocreate() {
		return whocreate;
	}

	/**
	 * @param whocreate
	 *            the whocreate to set
	 */
	public void setWhocreate(String whocreate) {
		this.whocreate = whocreate;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
		return "PlotOtherHost [id=" + id + ", usehost=" + usehost + ", pwd=" + pwd + ", isallot=" + isallot
				+ ", whocreate=" + whocreate + ", username=" + username + ", createtime=" + createtime + ", isuse="
				+ isuse + "]";
	}

	/**
	 * 
	 */
	public PlotOtherHost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param usehost
	 * @param pwd
	 * @param isallot
	 * @param whocreate
	 * @param username
	 * @param createtime
	 * @param isuse
	 */
	public PlotOtherHost(int id, String usehost, String pwd, int isallot, String whocreate, String username,
			String createtime, int isuse) {
		super();
		this.id = id;
		this.usehost = usehost;
		this.pwd = pwd;
		this.isallot = isallot;
		this.whocreate = whocreate;
		this.username = username;
		this.createtime = createtime;
		this.isuse = isuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + id;
		result = prime * result + isallot;
		result = prime * result + isuse;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((usehost == null) ? 0 : usehost.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((whocreate == null) ? 0 : whocreate.hashCode());
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
		PlotOtherHost other = (PlotOtherHost) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id != other.id)
			return false;
		if (isallot != other.isallot)
			return false;
		if (isuse != other.isuse)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (usehost == null) {
			if (other.usehost != null)
				return false;
		} else if (!usehost.equals(other.usehost))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (whocreate == null) {
			if (other.whocreate != null)
				return false;
		} else if (!whocreate.equals(other.whocreate))
			return false;
		return true;
	}

}
