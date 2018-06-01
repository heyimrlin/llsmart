/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午2:43:47
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
 * @author xiaoxl 平台配置用户
 */
@Entity
@Table(name = "sysuser", schema = "llsmart", catalog = "")
public class SysUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "uid", nullable = false)
	private String uid;// 用户ID，唯一标识

	@Basic
	@Column(name = "nickname", nullable = false)
	private String nickname;// 昵称

	@Basic
	@Column(name = "tell", nullable = false, length = 11)
	private String tell;// 手机号

	@Basic
	@Column(name = "houserole", nullable = false)
	private String houserole;// 家庭角色

	@Basic
	@Column(name = "mobilerg", nullable = false)
	private int mobilerg;// 手机端是否注册

	@Basic
	@Column(name = "useable", nullable = false)
	private int useable;// 是否停用

	@Basic
	@Column(name = "creator", nullable = false)
	private String creator;// 创建人

	@Basic
	@Column(name = "addtime", nullable = false)
	private String addtime;// 添加时间

	@Basic
	@Column(name = "familyhost", nullable = false)
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
	public String getHouserole() {
		return houserole;
	}

	/**
	 * @param houserole
	 *            the houserole to set
	 */
	public void setHouserole(String houserole) {
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
	public SysUser(int id, String uid, String nickname, String tell, String houserole, int mobilerg, int useable,
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

}
