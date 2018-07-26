/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午2:43:47
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
 * @author xiaoxl 平台配置用户
 */
@Entity
@Table(name = "sysuser", schema = "llsmart", catalog = "")
public class SysUser implements Serializable {

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
	@Column(name = "nickname", nullable = true)
	private String nickname;// 昵称

	@Basic
	@Column(name = "tell", nullable = true)
	private String tell;// 手机号

	@Basic
	@Column(name = "houserole", nullable = true)
	private int houserole;// 家庭角色

	@Basic
	@Column(name = "mobilerg", nullable = false)
	private int mobilerg;// 手机端是否注册

	@Basic
	@Column(name = "useable", nullable = false)
	private int useable;// 是否停用

	@Basic
	@Column(name = "creator", nullable = true)
	private String creator;// 创建人

	@Basic
	@Column(name = "addtime", nullable = true)
	private String addtime;// 添加时间

	@Basic
	@Column(name = "familyhost", nullable = true)
	private String familyhost;// 家庭业主

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
	 * @return the houserole
	 */
	public int getHouserole() {
		return houserole;
	}

	/**
	 * @param houserole
	 *            the houserole to set
	 */
	public void setHouserole(int houserole) {
		this.houserole = houserole;
	}

	/**
	 * @return the mobilerg
	 */
	public int getMobilerg() {
		return mobilerg;
	}

	/**
	 * @param mobilerg
	 *            the mobilerg to set
	 */
	public void setMobilerg(int mobilerg) {
		this.mobilerg = mobilerg;
	}

	/**
	 * @return the useable
	 */
	public int getUseable() {
		return useable;
	}

	/**
	 * @param useable
	 *            the useable to set
	 */
	public void setUseable(int useable) {
		this.useable = useable;
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
	 * @return the addtime
	 */
	public String getAddtime() {
		return addtime;
	}

	/**
	 * @param addtime
	 *            the addtime to set
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getFamilyhost() {
		return familyhost;
	}

	public void setFamilyhost(String familyhost) {
		this.familyhost = familyhost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", uid=" + uid + ", nickname=" + nickname + ", tell=" + tell + ", houserole="
				+ houserole + ", mobilerg=" + mobilerg + ", useable=" + useable + ", creator=" + creator + ", addtime="
				+ addtime + ", familyhost=" + familyhost + "]";
	}

	/**
	 * 
	 */
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param uid
	 * @param nickname
	 * @param tell
	 * @param houserole
	 * @param mobilerg
	 * @param useable
	 * @param creator
	 * @param addtime
	 */
	public SysUser(int id, String uid, String nickname, String tell, int houserole, int mobilerg, int useable,
			String creator, String addtime, String familyhost) {
		super();
		this.id = id;
		this.uid = uid;
		this.nickname = nickname;
		this.tell = tell;
		this.houserole = houserole;
		this.mobilerg = mobilerg;
		this.useable = useable;
		this.creator = creator;
		this.addtime = addtime;
		this.familyhost = familyhost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addtime == null) ? 0 : addtime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((familyhost == null) ? 0 : familyhost.hashCode());
		result = prime * result + houserole;
		result = prime * result + id;
		result = prime * result + mobilerg;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((tell == null) ? 0 : tell.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + useable;
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
		SysUser other = (SysUser) obj;
		if (addtime == null) {
			if (other.addtime != null)
				return false;
		} else if (!addtime.equals(other.addtime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (familyhost == null) {
			if (other.familyhost != null)
				return false;
		} else if (!familyhost.equals(other.familyhost))
			return false;
		if (houserole != other.houserole)
			return false;
		if (id != other.id)
			return false;
		if (mobilerg != other.mobilerg)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (tell == null) {
			if (other.tell != null)
				return false;
		} else if (!tell.equals(other.tell))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (useable != other.useable)
			return false;
		return true;
	}

}
