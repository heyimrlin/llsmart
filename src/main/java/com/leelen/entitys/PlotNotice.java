/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午5:09:33
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
 * @author xiaoxl 小区公告
 *
 */
@Entity
@Table(name = "plotnotice", schema = "llsmart", catalog = "")
public class PlotNotice implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "noticeid", nullable = false)
	private String noticeid;// 公告标识

	@Basic
	@Column(name = "noticetitle", nullable = false)
	private String noticetitle;// 公告标题

	@Basic
	@Column(name = "noticecontent", nullable = false)
	private String noticecontent;// 公告内容

	@Basic
	@Column(name = "modifytime", nullable = false)
	private String modifytime;// 最近修改日期

	@Basic
	@Column(name = "validity", nullable = true)
	private String validity;// 有效期

	@Basic
	@Column(name = "isshow", nullable = false)
	private int isshow;// 是否显示

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区id

	@Basic
	@Column(name = "plotname", nullable = false)
	private String plotname;// 小区名称

	@Basic
	@Column(name = "creator", nullable = false)
	private String creator;// 创建人

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
	 * @return the noticeid
	 */
	public String getNoticeid() {
		return noticeid;
	}

	/**
	 * @param noticeid
	 *            the noticeid to set
	 */
	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}

	/**
	 * @return the noticetitle
	 */
	public String getNoticetitle() {
		return noticetitle;
	}

	/**
	 * @param noticetitle
	 *            the noticetitle to set
	 */
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	/**
	 * @return the noticecontent
	 */
	public String getNoticecontent() {
		return noticecontent;
	}

	/**
	 * @param noticecontent
	 *            the noticecontent to set
	 */
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	/**
	 * @return the modifytime
	 */
	@JsonIgnore
	public String getModifytime() {
		return modifytime;
	}

	/**
	 * @param modifytime
	 *            the modifytime to set
	 */
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
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

	/**
	 * @return the plotname
	 */
	public String getPlotname() {
		return plotname;
	}

	/**
	 * @param plotname
	 *            the plotname to set
	 */
	public void setPlotname(String plotname) {
		this.plotname = plotname;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlotNotice [id=" + id + ", noticeid=" + noticeid + ", noticetitle=" + noticetitle + ", noticecontent="
				+ noticecontent + ", modifytime=" + modifytime + ", validity=" + validity + ", isshow=" + isshow
				+ ", plotid=" + plotid + ", plotname=" + plotname + ", creator=" + creator + "]";
	}

	/**
	 * 
	 */
	public PlotNotice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param noticeid
	 * @param noticetitle
	 * @param noticecontent
	 * @param modifytime
	 * @param validity
	 * @param isshow
	 * @param plotname
	 * @param creator
	 */
	public PlotNotice(int id, String noticeid, String noticetitle, String noticecontent, String modifytime,
			String validity, int isshow, String plotid, String plotname, String creator) {
		super();
		this.id = id;
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticecontent = noticecontent;
		this.modifytime = modifytime;
		this.validity = validity;
		this.isshow = isshow;
		this.plotid = plotid;
		this.plotname = plotname;
		this.creator = creator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + id;
		result = prime * result + isshow;
		result = prime * result + ((modifytime == null) ? 0 : modifytime.hashCode());
		result = prime * result + ((noticecontent == null) ? 0 : noticecontent.hashCode());
		result = prime * result + ((noticeid == null) ? 0 : noticeid.hashCode());
		result = prime * result + ((noticetitle == null) ? 0 : noticetitle.hashCode());
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((plotname == null) ? 0 : plotname.hashCode());
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
		PlotNotice other = (PlotNotice) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (id != other.id)
			return false;
		if (isshow != other.isshow)
			return false;
		if (modifytime == null) {
			if (other.modifytime != null)
				return false;
		} else if (!modifytime.equals(other.modifytime))
			return false;
		if (noticecontent == null) {
			if (other.noticecontent != null)
				return false;
		} else if (!noticecontent.equals(other.noticecontent))
			return false;
		if (noticeid == null) {
			if (other.noticeid != null)
				return false;
		} else if (!noticeid.equals(other.noticeid))
			return false;
		if (noticetitle == null) {
			if (other.noticetitle != null)
				return false;
		} else if (!noticetitle.equals(other.noticetitle))
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (plotname == null) {
			if (other.plotname != null)
				return false;
		} else if (!plotname.equals(other.plotname))
			return false;
		if (validity == null) {
			if (other.validity != null)
				return false;
		} else if (!validity.equals(other.validity))
			return false;
		return true;
	}

}
