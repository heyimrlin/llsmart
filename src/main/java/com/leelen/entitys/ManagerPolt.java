/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:35:21
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
 * @author xiaoxl 管理团队、小区
 *
 */
@Entity
@Table(name = "managerpolt", schema = "llsmart", catalog = "")
public class ManagerPolt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "aid", nullable = false)
	private String aid;// 管理员ID

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区IDplotname

	@Basic
	@Column(name = "plotname", nullable = false)
	private String plotname;// 小区名称

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
	@JsonIgnore
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
	 * @return the plotid
	 */
	@JsonIgnore
	public String getPlotid() {
		return plotid;
	}

	/**
	 * @param plotid
	 *            the plotid to set
	 */
	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}

	public String getPlotname() {
		return plotname;
	}

	public void setPlotname(String plotname) {
		this.plotname = plotname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManagerPolt [id=" + id + ", aid=" + aid + ", plotid=" + plotid + ", plotname=" + plotname + "]";
	}

	/**
	 * 
	 */
	public ManagerPolt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param aid
	 * @param plotid
	 */
	public ManagerPolt(int id, String aid, String plotid, String plotname) {
		super();
		this.id = id;
		this.aid = aid;
		this.plotid = plotid;
		this.plotname = plotname;
	}

}
