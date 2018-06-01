/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:15:39
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
 * @author xiaoxl 设备表
 *
 */
@Entity
@Table(name = "machineinfo", schema = "llsmart", catalog = "")
public class MachineInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "deviceid", nullable = false)
	private String deviceid;// 设备编号 规则:16社区号+4设备序号

	@Basic
	@Column(name = "devicename", nullable = false)
	private String devicename;// 设备名称标识

	@Basic
	@Column(name = "machinetype", nullable = false)
	private String machinetype;// 设备类型

	@Basic
	@Column(name = "devicesite", nullable = false)
	private String devicesite;// 设备位置 单元+位置

	@Basic
	@Column(name = "devicestatus", nullable = false)
	private int devicestatus;// 设备状态 是否可用

	@Basic
	@Column(name = "isactivate", nullable = false)
	private int isactivate;// 设备是否已激活

	@Basic
	@Column(name = "activationtime", nullable = true)
	private String activationtime;// 设备激活时间

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 创建时间

	@Basic
	@Column(name = "devicenote", nullable = true)
	private String devicenote;// 设备备注

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区ID

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
	 * @return the deviceid
	 */
	public String getDeviceid() {
		return deviceid;
	}

	/**
	 * @param deviceid
	 *            the deviceid to set
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	/**
	 * @return the devicename
	 */
	public String getDevicename() {
		return devicename;
	}

	/**
	 * @param devicename
	 *            the devicename to set
	 */
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	/**
	 * @return the machinetype
	 */
	public String getMachinetype() {
		return machinetype;
	}

	/**
	 * @param machinetype
	 *            the machinetype to set
	 */
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}

	/**
	 * @return the devicesite
	 */
	public String getDevicesite() {
		return devicesite;
	}

	/**
	 * @param devicesite
	 *            the devicesite to set
	 */
	public void setDevicesite(String devicesite) {
		this.devicesite = devicesite;
	}

	/**
	 * @return the devicestatus
	 */
	public int getDevicestatus() {
		return devicestatus;
	}

	/**
	 * @param devicestatus
	 *            the devicestatus to set
	 */
	public void setDevicestatus(int devicestatus) {
		this.devicestatus = devicestatus;
	}

	/**
	 * @return the isactivate
	 */
	public int getIsactivate() {
		return isactivate;
	}

	/**
	 * @param isactivate
	 *            the isactivate to set
	 */
	public void setIsactivate(int isactivate) {
		this.isactivate = isactivate;
	}

	/**
	 * @return the activationtime
	 */
	public String getActivationtime() {
		return activationtime;
	}

	/**
	 * @param activationtime
	 *            the activationtime to set
	 */
	public void setActivationtime(String activationtime) {
		this.activationtime = activationtime;
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
	 * @return the devicenote
	 */
	public String getDevicenote() {
		return devicenote;
	}

	/**
	 * @param devicenote
	 *            the devicenote to set
	 */
	public void setDevicenote(String devicenote) {
		this.devicenote = devicenote;
	}

	/**
	 * @return the plotid
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MachineInfo [id=" + id + ", deviceid=" + deviceid + ", devicename=" + devicename + ", machinetype="
				+ machinetype + ", devicesite=" + devicesite + ", devicestatus=" + devicestatus + ", isactivate="
				+ isactivate + ", activationtime=" + activationtime + ", createtime=" + createtime + ", devicenote="
				+ devicenote + ", plotid=" + plotid + "]";
	}

	/**
	 * 
	 */
	public MachineInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param deviceid
	 * @param devicename
	 * @param machinetype
	 * @param devicesite
	 * @param devicestatus
	 * @param isactivate
	 * @param activationtime
	 * @param createtime
	 * @param devicenote
	 * @param plotid
	 */
	public MachineInfo(int id, String deviceid, String devicename, String machinetype, String devicesite,
			int devicestatus, int isactivate, String activationtime, String createtime, String devicenote,
			String plotid) {
		super();
		this.id = id;
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.machinetype = machinetype;
		this.devicesite = devicesite;
		this.devicestatus = devicestatus;
		this.isactivate = isactivate;
		this.activationtime = activationtime;
		this.createtime = createtime;
		this.devicenote = devicenote;
		this.plotid = plotid;
	}

}
