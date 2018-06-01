/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:05:50
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
 * @author xiaoxl 门禁卡管理
 *
 */
@Entity
@Table(name = "egcard", schema = "llsmart", catalog = "")
public class EgCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "cardno", nullable = false)
	private String cardno;// 门禁卡号

	@Basic
	@Column(name = "egcardtype", nullable = false)
	private int egcardtype;// 门禁卡类型:0标识物业卡 1标识普通卡

	@Basic
	@Column(name = "limitnum", nullable = false)
	private int limitnum;// 门禁卡权限数

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 门禁卡创建时间

	@Basic
	@Column(name = "validtime", nullable = false)
	private String validtime;// 门禁卡有效时间

	@Basic
	@Column(name = "isvalid", nullable = false)
	private int isvalid;// 门禁卡是否有效

	@Basic
	@Column(name = "isuse", nullable = true)
	private int isuse;// 门禁卡号是否限制(时间)

	@Basic
	@Column(name = "logoutstatus", nullable = false)
	private int logoutstatus;// 门禁卡注销状态

	@Basic
	@Column(name = "creator", nullable = false)
	private String creator;// 创建人

	@Basic
	@Column(name = "cardholder", nullable = false)
	private String cardholder;// 持卡人

	@Basic
	@Column(name = "note", nullable = true)
	private String note;// 备注

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
	 * @return the cardno
	 */
	public String getCardno() {
		return cardno;
	}

	/**
	 * @param cardno
	 *            the cardno to set
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	/**
	 * @return the egcardtype
	 */
	public int getEgcardtype() {
		return egcardtype;
	}

	/**
	 * @param egcardtype
	 *            the egcardtype to set
	 */
	public void setEgcardtype(int egcardtype) {
		this.egcardtype = egcardtype;
	}

	/**
	 * @return the limitnum
	 */
	public int getLimitnum() {
		return limitnum;
	}

	/**
	 * @param limitnum
	 *            the limitnum to set
	 */
	public void setLimitnum(int limitnum) {
		this.limitnum = limitnum;
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
	 * @return the validtime
	 */
	public String getValidtime() {
		return validtime;
	}

	/**
	 * @param validtime
	 *            the validtime to set
	 */
	public void setValidtime(String validtime) {
		this.validtime = validtime;
	}

	/**
	 * @return the isvalid
	 */
	public int getIsvalid() {
		return isvalid;
	}

	/**
	 * @param isvalid
	 *            the isvalid to set
	 */
	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
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
	 * @return the logoutstatus
	 */
	public int getLogoutstatus() {
		return logoutstatus;
	}

	/**
	 * @param logoutstatus
	 *            the logoutstatus to set
	 */
	public void setLogoutstatus(int logoutstatus) {
		this.logoutstatus = logoutstatus;
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
	 * @return the cardholder
	 */
	public String getCardholder() {
		return cardholder;
	}

	/**
	 * @param cardholder
	 *            the cardholder to set
	 */
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EgCard [id=" + id + ", cardno=" + cardno + ", egcardtype=" + egcardtype + ", limitnum=" + limitnum
				+ ", createtime=" + createtime + ", validtime=" + validtime + ", isvalid=" + isvalid + ", isuse="
				+ isuse + ", logoutstatus=" + logoutstatus + ", creator=" + creator + ", cardholder=" + cardholder
				+ ", note=" + note + "]";
	}

	/**
	 * 
	 */
	public EgCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param cardno
	 * @param egcardtype
	 * @param limitnum
	 * @param createtime
	 * @param validtime
	 * @param isvalid
	 * @param isuse
	 * @param logoutstatus
	 * @param creator
	 * @param cardholder
	 * @param note
	 */
	public EgCard(int id, String cardno, int egcardtype, int limitnum, String createtime, String validtime, int isvalid,
			int isuse, int logoutstatus, String creator, String cardholder, String note) {
		super();
		this.id = id;
		this.cardno = cardno;
		this.egcardtype = egcardtype;
		this.limitnum = limitnum;
		this.createtime = createtime;
		this.validtime = validtime;
		this.isvalid = isvalid;
		this.isuse = isuse;
		this.logoutstatus = logoutstatus;
		this.creator = creator;
		this.cardholder = cardholder;
		this.note = note;
	}

}
