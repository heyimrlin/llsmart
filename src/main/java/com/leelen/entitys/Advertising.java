/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:17:26
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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author xiaoxl 广告表 平台、小区
 *
 */
@Entity
@Table(name = "advertising", schema = "llsmart", catalog = "")
public class Advertising implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "advid", nullable = false)
	private String advid;// 广告ID，唯一标识

	@Basic
	@Column(name = "advtitle", nullable = false)
	private String advtitle;// 广告标题

	@Basic
	@Column(name = "advcontent", nullable = false)
	private String advcontent;// 广告内容

	@Basic
	@Column(name = "advlink", nullable = false)
	private String advlink;// 广告链接

	@Basic
	@Column(name = "advimg", nullable = false)
	private String advimg;// 广告图片，主图

	@Basic
	@Column(name = "advtype", nullable = false)
	private String advtype;// 广告类型，0表示平台广告 1表示小区广告

	@Basic
	@Column(name = "creator", nullable = false)
	private String creator;// 创建人，发布人

	@Basic
	@Column(name = "validity", nullable = true)
	private String validity;// 有效期

	@Basic
	@Column(name = "auditstatus", nullable = false)
	private int auditstatus;// 审核状态

	@Basic
	@Column(name = "auditer", nullable = true)
	private String auditer;// 审核人

	@Basic
	@Column(name = "audittime", nullable = true)
	private String audittime;// 审核时间

	@Basic
	@Column(name = "isshow", nullable = false)
	private int isshow;// 是否显示 0表示不显示 1表示显示

	@Basic
	@Column(name = "plotid", nullable = true)
	private String plotid;// 小区ID

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
	 * @return the advid
	 */
	@JsonIgnore
	public String getAdvid() {
		return advid;
	}

	/**
	 * @param advid
	 *            the advid to set
	 */
	public void setAdvid(String advid) {
		this.advid = advid;
	}

	/**
	 * @return the advtitle
	 */
	public String getAdvtitle() {
		return advtitle;
	}

	/**
	 * @param advtitle
	 *            the advtitle to set
	 */
	public void setAdvtitle(String advtitle) {
		this.advtitle = advtitle;
	}

	/**
	 * @return the advcontent
	 */
	public String getAdvcontent() {
		return advcontent;
	}

	/**
	 * @param advcontent
	 *            the advcontent to set
	 */
	public void setAdvcontent(String advcontent) {
		this.advcontent = advcontent;
	}

	/**
	 * @return the advlink
	 */
	public String getAdvlink() {
		return advlink;
	}

	/**
	 * @param advlink
	 *            the advlink to set
	 */
	public void setAdvlink(String advlink) {
		this.advlink = advlink;
	}

	/**
	 * @return the advimg
	 */
	public String getAdvimg() {
		return advimg;
	}

	/**
	 * @param advimg
	 *            the advimg to set
	 */
	public void setAdvimg(String advimg) {
		this.advimg = advimg;
	}

	/**
	 * @return the advtype
	 */
	public String getAdvtype() {
		return advtype;
	}

	/**
	 * @param advtype
	 *            the advtype to set
	 */
	public void setAdvtype(String advtype) {
		this.advtype = advtype;
	}

	/**
	 * @return the creator
	 */
	@JsonIgnore
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
	 * @return the validity
	 */
	public String getValidity() {
		return validity;
	}

	/**
	 * @param validity
	 *            the validity to set
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}

	/**
	 * @return the auditstatus
	 */
	public int getAuditstatus() {
		return auditstatus;
	}

	/**
	 * @param auditstatus
	 *            the auditstatus to set
	 */
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
	}

	/**
	 * @return the auditer
	 */
	@JsonIgnore
	public String getAuditer() {
		return auditer;
	}

	/**
	 * @param auditer
	 *            the auditer to set
	 */
	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}

	/**
	 * @return the audittime
	 */
	@JsonIgnore
	public String getAudittime() {
		return audittime;
	}

	/**
	 * @param audittime
	 *            the audittime to set
	 */
	public void setAudittime(String audittime) {
		this.audittime = audittime;
	}

	/**
	 * @return the isshow
	 */
	@JsonIgnore
	public int getIsshow() {
		return isshow;
	}

	/**
	 * @param isshow
	 *            the isshow to set
	 */
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public String getPlotid() {
		return plotid;
	}

	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Advertising [id=" + id + ", advid=" + advid + ", advtitle=" + advtitle + ", advcontent=" + advcontent
				+ ", advlink=" + advlink + ", advimg=" + advimg + ", advtype=" + advtype + ", creator=" + creator
				+ ", validity=" + validity + ", auditstatus=" + auditstatus + ", auditer=" + auditer + ", audittime="
				+ audittime + ", isshow=" + isshow + ", plotid=" + plotid + "]";
	}

	/**
	 * 
	 */
	public Advertising() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param advid
	 * @param advtitle
	 * @param advcontent
	 * @param advlink
	 * @param advimg
	 * @param advtype
	 * @param creator
	 * @param validity
	 * @param auditstatus
	 * @param auditer
	 * @param audittime
	 * @param isshow
	 */
	public Advertising(int id, String advid, String advtitle, String advcontent, String advlink, String advimg,
			String advtype, String creator, String validity, int auditstatus, String auditer, String audittime,
			int isshow, String plotid) {
		super();
		this.id = id;
		this.advid = advid;
		this.advtitle = advtitle;
		this.advcontent = advcontent;
		this.advlink = advlink;
		this.advimg = advimg;
		this.advtype = advtype;
		this.creator = creator;
		this.validity = validity;
		this.auditstatus = auditstatus;
		this.auditer = auditer;
		this.audittime = audittime;
		this.isshow = isshow;
		this.plotid = plotid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advcontent == null) ? 0 : advcontent.hashCode());
		result = prime * result + ((advid == null) ? 0 : advid.hashCode());
		result = prime * result + ((advimg == null) ? 0 : advimg.hashCode());
		result = prime * result + ((advlink == null) ? 0 : advlink.hashCode());
		result = prime * result + ((advtitle == null) ? 0 : advtitle.hashCode());
		result = prime * result + ((advtype == null) ? 0 : advtype.hashCode());
		result = prime * result + ((auditer == null) ? 0 : auditer.hashCode());
		result = prime * result + auditstatus;
		result = prime * result + ((audittime == null) ? 0 : audittime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + id;
		result = prime * result + isshow;
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((validity == null) ? 0 : validity.hashCode());
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
		Advertising other = (Advertising) obj;
		if (advcontent == null) {
			if (other.advcontent != null)
				return false;
		} else if (!advcontent.equals(other.advcontent))
			return false;
		if (advid == null) {
			if (other.advid != null)
				return false;
		} else if (!advid.equals(other.advid))
			return false;
		if (advimg == null) {
			if (other.advimg != null)
				return false;
		} else if (!advimg.equals(other.advimg))
			return false;
		if (advlink == null) {
			if (other.advlink != null)
				return false;
		} else if (!advlink.equals(other.advlink))
			return false;
		if (advtitle == null) {
			if (other.advtitle != null)
				return false;
		} else if (!advtitle.equals(other.advtitle))
			return false;
		if (advtype == null) {
			if (other.advtype != null)
				return false;
		} else if (!advtype.equals(other.advtype))
			return false;
		if (auditer == null) {
			if (other.auditer != null)
				return false;
		} else if (!auditer.equals(other.auditer))
			return false;
		if (auditstatus != other.auditstatus)
			return false;
		if (audittime == null) {
			if (other.audittime != null)
				return false;
		} else if (!audittime.equals(other.audittime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (id != other.id)
			return false;
		if (isshow != other.isshow)
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (validity == null) {
			if (other.validity != null)
				return false;
		} else if (!validity.equals(other.validity))
			return false;
		return true;
	}

}
