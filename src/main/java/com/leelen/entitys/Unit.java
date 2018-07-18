/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:42:57
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
 * @author xiaoxl 小区
 *
 */
@Entity
@Table(name = "unit", schema = "llsmart", catalog = "")
public class Unit implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "unitid", nullable = false)
	private String unitid;// 单元名称

	@Basic
	@Column(name = "unitname", nullable = false)
	private String unitname;// 小区所在地

	@Basic
	@Column(name = "unittype", nullable = false)
	private int unittype;// 小区状态

	@Basic
	@Column(name = "devicenum", nullable = false)
	private int devicenum;// 小区创建时间

	@Basic
	@Column(name = "floornum", nullable = false)
	private int floornum;// 小区创建人

	@Basic
	@Column(name = "status", nullable = false)
	private int status;// 小区创建时间

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 小区创建人

	@Basic
	@Column(name = "creater", nullable = false)
	private String creater;// 小区创建人

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区id

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

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public int getUnittype() {
		return unittype;
	}

	public void setUnittype(int unittype) {
		this.unittype = unittype;
	}

	public int getDevicenum() {
		return devicenum;
	}

	public void setDevicenum(int devicenum) {
		this.devicenum = devicenum;
	}

	public int getFloornum() {
		return floornum;
	}

	public void setFloornum(int floornum) {
		this.floornum = floornum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getPlotid() {
		return plotid;
	}

	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}

	/**
	 * 
	 */
	public Unit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param unitid
	 * @param unitname
	 * @param unittype
	 * @param devicenum
	 * @param floornum
	 * @param status
	 * @param createtime
	 * @param creater
	 * @param plotid
	 */
	public Unit(int id, String unitid, String unitname, int unittype, int devicenum, int floornum, int status,
			String createtime, String creater, String plotid) {
		this.id = id;
		this.unitid = unitid;
		this.unitname = unitname;
		this.unittype = unittype;
		this.devicenum = devicenum;
		this.floornum = floornum;
		this.status = status;
		this.createtime = createtime;
		this.creater = creater;
		this.plotid = plotid;
	}

}
