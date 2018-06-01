/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:09:56
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author xiaoxl 管理员
 */
@Entity
@Table(name = "administrator", schema = "llsmart", catalog = "")
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "aid", nullable = false)
	private String aid;// 管理员ID，唯一标识

	@Basic
	@Column(name = "nickname", nullable = false)
	private String nickname;// 昵称

	@Basic
	@Column(name = "account", nullable = false)
	private String account;// 账号，唯一标识

	@Basic
	@Column(name = "tell", nullable = false)
	private String tell;// 手机号

	@JsonIgnore
	@Basic
	@Column(name = "password", nullable = false)
	private String password;// 密码

	@Basic
	@Column(name = "creator", nullable = false)
	private String creator;// 创建人

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 创建时间

	@Basic
	@Column(name = "isuse", nullable = false)
	private int isuse;// 是否停用

	@Basic
	@Column(name = "lastlogintime", nullable = true)
	private String lastlogintime;// 最后登录时间

	@Basic
	@Column(name = "parentsaccount", nullable = false)
	private String parentsaccount;// 上级账号

	@Basic
	@Column(name = "roleid", nullable = false)
	private String roleid;// 角色标识

	// @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
	// private List<Administrator> user = new LinkedList<Administrator>();

	// @OneToMany(mappedBy = "administrator")
	// private List<Administrator> buser = new LinkedList<Administrator>();

	/**
	 * @return the id
	 */
	@JsonIgnore
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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell
	 *            the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
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
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
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

	/**
	 * @return the lastlogintime
	 */
	public String getLastlogintime() {
		return lastlogintime;
	}

	/**
	 * @param lastlogintime
	 *            the lastlogintime to set
	 */
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	/**
	 * @return the parentsaccount
	 */
	public String getParentsaccount() {
		return parentsaccount;
	}

	/**
	 * @param parentsaccount
	 *            the parentsaccount to set
	 */
	public void setParentsaccount(String parentsaccount) {
		this.parentsaccount = parentsaccount;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", account=" + account
				+ ", tell=" + tell + ", password=" + password + ", creator=" + creator + ", createtime=" + createtime
				+ ", isuse=" + isuse + ", lastlogintime=" + lastlogintime + ", parentsaccount=" + parentsaccount
				+ ", roleid=" + roleid + "]";
	}

	/**
	 * 
	 */
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param aid
	 * @param nickname
	 * @param account
	 * @param tell
	 * @param password
	 * @param creator
	 * @param createtime
	 * @param isuse
	 * @param lastlogintime
	 * @param parentsaccount
	 * @param roleid
	 */
	public Administrator(int id, String aid, String nickname, String account, String tell, String password,
			String creator, String createtime, int isuse, String lastlogintime, String parentsaccount, String roleid) {
		super();
		this.id = id;
		this.aid = aid;
		this.nickname = nickname;
		this.account = account;
		this.tell = tell;
		this.password = password;
		this.creator = creator;
		this.createtime = createtime;
		this.isuse = isuse;
		this.lastlogintime = lastlogintime;
		this.parentsaccount = parentsaccount;
		this.roleid = roleid;
	}

}
