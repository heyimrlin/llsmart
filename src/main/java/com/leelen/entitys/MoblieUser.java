/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:39:20
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
 * @author xiaoxl 移动端注册表
 *
 */
@Entity
@Table(name = "moblieuser", schema = "llsmart", catalog = "")
public class MoblieUser implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "uid", nullable = false)
	private String uid;// 用户ID，唯一标识

	@Basic
	@Column(name = "tell", nullable = false, length = 11)
	private String tell;// 手机号

	@Basic
	@Column(name = "password", nullable = false)
	private String password;// 密码

	@Basic
	@Column(name = "registertime", nullable = false)
	private String registertime;// 注册时间

	@Basic
	@Column(name = "token", nullable = true)
	private String token;// Token，唯一标识

	@Basic
	@Column(name = "tokentime", nullable = true)
	private String tokentime;// Token生成时间

	@Basic
	@Column(name = "isplatform", nullable = false)
	private int isplatform;// 平台是否配置

	@Basic
	@Column(name = "isonline", nullable = false)
	private int isonline;// 是否在线

	@Basic
	@Column(name = "lastlogintime", nullable = false)
	private String lastlogintime;// 最后登录时间

	@Basic
	@Column(name = "loginip", nullable = false)
	private String loginip;// 登录ip

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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * @return the registertime
	 */
	public String getRegistertime() {
		return registertime;
	}

	/**
	 * @param registertime
	 *            the registertime to set
	 */
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
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
	 * @param tokentime
	 *            the tokentime to set
	 */
	public void setTokentime(String tokentime) {
		this.tokentime = tokentime;
	}

	/**
	 * @return the isplatform
	 */
	public int getIsplatform() {
		return isplatform;
	}

	/**
	 * @param isplatform
	 *            the isplatform to set
	 */
	public void setIsplatform(int isplatform) {
		this.isplatform = isplatform;
	}

	/**
	 * @return the isonline
	 */
	public int getIsonline() {
		return isonline;
	}

	/**
	 * @param isonline
	 *            the isonline to set
	 */
	public void setIsonline(int isonline) {
		this.isonline = isonline;
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
	 * @return the loginip
	 */
	public String getLoginip() {
		return loginip;
	}

	/**
	 * @param loginip
	 *            the loginip to set
	 */
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoblieUser [id=" + id + ", uid=" + uid + ", tell=" + tell + ", password=" + password + ", registertime="
				+ registertime + ", token=" + token + ", tokentime=" + tokentime + ", isplatform=" + isplatform
				+ ", isonline=" + isonline + ", lastlogintime=" + lastlogintime + ", loginip=" + loginip + "]";
	}

	/**
	 * 
	 */
	public MoblieUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param uid
	 * @param tell
	 * @param password
	 * @param registertime
	 * @param token
	 * @param tokentime
	 * @param isplatform
	 * @param isonline
	 * @param lastlogintime
	 * @param loginip
	 */
	public MoblieUser(int id, String uid, String tell, String password, String registertime, String token,
			String tokentime, int isplatform, int isonline, String lastlogintime, String loginip) {
		super();
		this.id = id;
		this.uid = uid;
		this.tell = tell;
		this.password = password;
		this.registertime = registertime;
		this.token = token;
		this.tokentime = tokentime;
		this.isplatform = isplatform;
		this.isonline = isonline;
		this.lastlogintime = lastlogintime;
		this.loginip = loginip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + isonline;
		result = prime * result + isplatform;
		result = prime * result + ((lastlogintime == null) ? 0 : lastlogintime.hashCode());
		result = prime * result + ((loginip == null) ? 0 : loginip.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registertime == null) ? 0 : registertime.hashCode());
		result = prime * result + ((tell == null) ? 0 : tell.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((tokentime == null) ? 0 : tokentime.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		MoblieUser other = (MoblieUser) obj;
		if (id != other.id)
			return false;
		if (isonline != other.isonline)
			return false;
		if (isplatform != other.isplatform)
			return false;
		if (lastlogintime == null) {
			if (other.lastlogintime != null)
				return false;
		} else if (!lastlogintime.equals(other.lastlogintime))
			return false;
		if (loginip == null) {
			if (other.loginip != null)
				return false;
		} else if (!loginip.equals(other.loginip))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registertime == null) {
			if (other.registertime != null)
				return false;
		} else if (!registertime.equals(other.registertime))
			return false;
		if (tell == null) {
			if (other.tell != null)
				return false;
		} else if (!tell.equals(other.tell))
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
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

}
