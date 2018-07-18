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

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午4:55:10
 * @class WyToken.java
 */
@Entity
@Table(name = "wytoken", schema = "llsmart", catalog = "")
public class WyToken implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "aid", nullable = false)
	private String aid;// 管理员ID，唯一标识

	@Basic
	@Column(name = "token", nullable = true)
	private String token;// token

	@Basic
	@Column(name = "tokentime", nullable = true)
	private String tokentime;// 生成token时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokentime() {
		return tokentime;
	}

	public void setTokentime(String tokentime) {
		this.tokentime = tokentime;
	}

	@Override
	public String toString() {
		return "WyToken [id=" + id + ", aid=" + aid + ", token=" + token + ", tokentime=" + tokentime + "]";
	}

	/**
	 * 
	 */
	public WyToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param aid
	 * @param token
	 * @param tokentime
	 */
	public WyToken(int id, String aid, String token, String tokentime) {
		super();
		this.id = id;
		this.aid = aid;
		this.token = token;
		this.tokentime = tokentime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + id;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((tokentime == null) ? 0 : tokentime.hashCode());
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
		WyToken other = (WyToken) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (id != other.id)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokentime == null) {
			if (other.tokentime != null)
				return false;
		} else if (!tokentime.equals(other.tokentime))
			return false;
		return true;
	}

	/**
	 * <p>
	 * Title: clone
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * @see java.lang.Object#clone()
	 */

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (WyToken) super.clone();
	}

}
