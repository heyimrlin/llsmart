/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午4:15:39
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
 * @author xiaoxl 设备表
 *
 */
@Entity
@Table(name = "machineinfo", schema = "llsmart", catalog = "")
public class MachineInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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
	@Column(name = "devicecode", nullable = false)
	private String devicecode;// 设备子码

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
	private String plotid;// 小区IDunitid

	@Basic
	@Column(name = "unitid", nullable = false)
	private String unitid;// 小区ID

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

	public String getDevicecode() {
		return devicecode;
	}

	public void setDevicecode(String devicecode) {
		this.devicecode = devicecode;
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

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MachineInfo [id=" + id + ", deviceid=" + deviceid + ", devicename=" + devicename + ", devicecode="
				+ devicecode + ", machinetype=" + machinetype + ", devicesite=" + devicesite + ", devicestatus="
				+ devicestatus + ", isactivate=" + isactivate + ", activationtime=" + activationtime + ", createtime="
				+ createtime + ", devicenote=" + devicenote + ", plotid=" + plotid + ",unitid=" + unitid + "]";
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
	public MachineInfo(int id, String deviceid, String devicename, String devicecode, String machinetype,
			String devicesite, int devicestatus, int isactivate, String activationtime, String createtime,
			String devicenote, String plotid, String unitid) {
		super();
		this.id = id;
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.devicecode = devicecode;
		this.machinetype = machinetype;
		this.devicesite = devicesite;
		this.devicestatus = devicestatus;
		this.isactivate = isactivate;
		this.activationtime = activationtime;
		this.createtime = createtime;
		this.devicenote = devicenote;
		this.plotid = plotid;
		this.unitid = unitid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activationtime == null) ? 0 : activationtime.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((devicecode == null) ? 0 : devicecode.hashCode());
		result = prime * result + ((deviceid == null) ? 0 : deviceid.hashCode());
		result = prime * result + ((devicename == null) ? 0 : devicename.hashCode());
		result = prime * result + ((devicenote == null) ? 0 : devicenote.hashCode());
		result = prime * result + ((devicesite == null) ? 0 : devicesite.hashCode());
		result = prime * result + devicestatus;
		result = prime * result + id;
		result = prime * result + isactivate;
		result = prime * result + ((machinetype == null) ? 0 : machinetype.hashCode());
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((unitid == null) ? 0 : unitid.hashCode());
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
		MachineInfo other = (MachineInfo) obj;
		if (activationtime == null) {
			if (other.activationtime != null)
				return false;
		} else if (!activationtime.equals(other.activationtime))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (devicecode == null) {
			if (other.devicecode != null)
				return false;
		} else if (!devicecode.equals(other.devicecode))
			return false;
		if (deviceid == null) {
			if (other.deviceid != null)
				return false;
		} else if (!deviceid.equals(other.deviceid))
			return false;
		if (devicename == null) {
			if (other.devicename != null)
				return false;
		} else if (!devicename.equals(other.devicename))
			return false;
		if (devicenote == null) {
			if (other.devicenote != null)
				return false;
		} else if (!devicenote.equals(other.devicenote))
			return false;
		if (devicesite == null) {
			if (other.devicesite != null)
				return false;
		} else if (!devicesite.equals(other.devicesite))
			return false;
		if (devicestatus != other.devicestatus)
			return false;
		if (id != other.id)
			return false;
		if (isactivate != other.isactivate)
			return false;
		if (machinetype == null) {
			if (other.machinetype != null)
				return false;
		} else if (!machinetype.equals(other.machinetype))
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (unitid == null) {
			if (other.unitid != null)
				return false;
		} else if (!unitid.equals(other.unitid))
			return false;
		return true;
	}

}
