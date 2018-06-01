/**
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
 * @author xiaoxl by male
 * @time 2018年5月19日下午4:55:10
 * @class WyToken.java
 */
@Entity
@Table(name = "wytoken", schema = "llsmart", catalog = "")
public class WyToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "aid", nullable = false)
	private String aid;// 管理员ID，唯一标识

	@Basic
	@Column(name = "token", nullable = false)
	private String token;// token

	@Basic
	@Column(name = "tokentime", nullable = false)
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

}
