package com.leelen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class AdminUser {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "aid", unique = true)
	private String aid;
	@Column(name = "tell")
	private String tell;
	@Column(name = "account")
	private String account;
	@Column(name = "password")
	private String password;
	@Column(name = "roleid")
	private int roleid;
	@Column(name = "hostname")
	private String hostname;
	@Column(name = "position")
	private String position;
	@Column(name = "note")
	private String note;
	@Column(name = "createtime")
	private String createtime;
	@Column(name = "token")
	private String token;
	@Column(name = "tokentime")
	private String tokentime;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}

	/**
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}

	
	/**
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid
	 *            the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	
	
	/**
	 * @return the tokentime
	 */
	public String getTokentime() {
		return tokentime;
	}

	/**
	 * @param tokentime the tokentime to set
	 */
	public void setTokentime(String tokentime) {
		this.tokentime = tokentime;
	}

	/**
	 * 
	 */
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param aid
	 * @param account
	 * @param password
	 * @param roleid
	 * @param hostname
	 * @param position
	 * @param note
	 * @param createtime
	 */
	public AdminUser(long id, String aid, String tell, String account, String password, int roleid, String hostname,
			String position, String note, String createtime,String token, String tokentime) {
		super();
		this.id = id;
		this.aid = aid;
		this.tell = tell;
		this.account = account;
		this.password = password;
		this.roleid = roleid;
		this.hostname = hostname;
		this.position = position;
		this.note = note;
		this.createtime = createtime;
		this.token = token;
		this.tokentime = tokentime;
	}

}
