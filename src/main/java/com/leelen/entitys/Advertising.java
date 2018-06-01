/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:17:26
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
 * @author xiaoxl 广告表 平台、小区
 *
 */
@Entity
@Table(name = "advertising", schema = "llsmart", catalog = "")
public class Advertising {

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

}
