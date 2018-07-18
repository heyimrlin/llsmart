/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:05:50
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
 * @author xiaoxl 门禁卡管理
 *
 */
@Entity
@Table(name = "egcard", schema = "llsmart", catalog = "")
public class EgCard implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardholder == null) ? 0 : cardholder.hashCode());
		result = prime * result + ((cardno == null) ? 0 : cardno.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + egcardtype;
		result = prime * result + id;
		result = prime * result + isuse;
		result = prime * result + isvalid;
		result = prime * result + limitnum;
		result = prime * result + logoutstatus;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((validtime == null) ? 0 : validtime.hashCode());
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
		EgCard other = (EgCard) obj;
		if (cardholder == null) {
			if (other.cardholder != null)
				return false;
		} else if (!cardholder.equals(other.cardholder))
			return false;
		if (cardno == null) {
			if (other.cardno != null)
				return false;
		} else if (!cardno.equals(other.cardno))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (egcardtype != other.egcardtype)
			return false;
		if (id != other.id)
			return false;
		if (isuse != other.isuse)
			return false;
		if (isvalid != other.isvalid)
			return false;
		if (limitnum != other.limitnum)
			return false;
		if (logoutstatus != other.logoutstatus)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (validtime == null) {
			if (other.validtime != null)
				return false;
		} else if (!validtime.equals(other.validtime))
			return false;
		return true;
	}

}
