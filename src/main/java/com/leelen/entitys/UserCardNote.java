/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:34:57
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
 * @author xiaoxl 住户进出记录
 *
 */
@Entity
@Table(name = "usercardnote", schema = "llsmart", catalog = "")
public class UserCardNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "uid", nullable = false)
	private String uid;// 用户ID，唯一标识

	@Basic
	@Column(name = "egid", nullable = false, length = 12)
	private String egid;// 开锁ID 产生id

	@Basic
	@Column(name = "unlockunit", nullable = false)
	private String unlockunit;// 开锁单元

	@Basic
	@Column(name = "slotcardtime", nullable = false)
	private String slotcardtime;// 开锁时间

	@Basic
	@Column(name = "isok", nullable = true)
	private int isok;// 是否正常 0正常 1异常

	@Basic
	@Column(name = "slotcardtype", nullable = false)
	private int slotcardtype;// 触发门禁类型 0 门口机、1围墙机...

	@Basic
	@Column(name = "inouttype", nullable = false)
	private int inouttype;// 进出类型 0出 1进

	@Basic
	@Column(name = "uploader", nullable = false)
	private String uploader;// 上传人

	@Basic
	@Column(name = "uploadtime", nullable = false)
	private String uploadtime;// 上传时间

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
	 * @return the egid
	 */
	public String getEgid() {
		return egid;
	}

	/**
	 * @param egid
	 *            the egid to set
	 */
	public void setEgid(String egid) {
		this.egid = egid;
	}

	/**
	 * @return the unlockunit
	 */
	public String getUnlockunit() {
		return unlockunit;
	}

	/**
	 * @param unlockunit
	 *            the unlockunit to set
	 */
	public void setUnlockunit(String unlockunit) {
		this.unlockunit = unlockunit;
	}

	/**
	 * @return the slotcardtime
	 */
	public String getSlotcardtime() {
		return slotcardtime;
	}

	/**
	 * @param slotcardtime
	 *            the slotcardtime to set
	 */
	public void setSlotcardtime(String slotcardtime) {
		this.slotcardtime = slotcardtime;
	}

	/**
	 * @return the isok
	 */
	public int getIsok() {
		return isok;
	}

	/**
	 * @param isok
	 *            the isok to set
	 */
	public void setIsok(int isok) {
		this.isok = isok;
	}

	/**
	 * @return the slotcardtype
	 */
	public int getSlotcardtype() {
		return slotcardtype;
	}

	/**
	 * @param slotcardtype
	 *            the slotcardtype to set
	 */
	public void setSlotcardtype(int slotcardtype) {
		this.slotcardtype = slotcardtype;
	}

	/**
	 * @return the inouttype
	 */
	public int getInouttype() {
		return inouttype;
	}

	/**
	 * @param inouttype
	 *            the inouttype to set
	 */
	public void setInouttype(int inouttype) {
		this.inouttype = inouttype;
	}

	/**
	 * @return the uploader
	 */
	public String getUploader() {
		return uploader;
	}

	/**
	 * @param uploader
	 *            the uploader to set
	 */
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	/**
	 * @return the uploadtime
	 */
	public String getUploadtime() {
		return uploadtime;
	}

	/**
	 * @param uploadtime
	 *            the uploadtime to set
	 */
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCardNote [id=" + id + ", uid=" + uid + ", egid=" + egid + ", unlockunit=" + unlockunit
				+ ", slotcardtime=" + slotcardtime + ", isok=" + isok + ", slotcardtype=" + slotcardtype
				+ ", inouttype=" + inouttype + ", uploader=" + uploader + ", uploadtime=" + uploadtime + "]";
	}

	/**
	 * 
	 */
	public UserCardNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param uid
	 * @param egid
	 * @param unlockunit
	 * @param slotcardtime
	 * @param isok
	 * @param slotcardtype
	 * @param inouttype
	 * @param uploader
	 * @param uploadtime
	 */
	public UserCardNote(int id, String uid, String egid, String unlockunit, String slotcardtime, int isok,
			int slotcardtype, int inouttype, String uploader, String uploadtime) {
		super();
		this.id = id;
		this.uid = uid;
		this.egid = egid;
		this.unlockunit = unlockunit;
		this.slotcardtime = slotcardtime;
		this.isok = isok;
		this.slotcardtype = slotcardtype;
		this.inouttype = inouttype;
		this.uploader = uploader;
		this.uploadtime = uploadtime;
	}

}
