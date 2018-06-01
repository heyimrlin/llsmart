/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午6:43:08
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
 * @author xiaoxl 住户小区表
 *
 */
@Entity
@Table(name = "userplot", schema = "llsmart", catalog = "")
public class UserPlot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "uid", nullable = false)
	private String uid;// 用户ID，唯一标识

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区ID，唯一标识

	@Basic
	@Column(name = "plotname", nullable = false)
	private String plotname;// 小区名称

	@Basic
	@Column(name = "buildingname", nullable = false)
	private String buildingname;// 单元、楼幢名称

	@Basic
	@Column(name = "room", nullable = false)
	private String room;// 房间名称

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
	 * @return the uid
	 */
	@JsonIgnore
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

	/**
	 * @return the buildingname
	 */
	public String getBuildingname() {
		return buildingname;
	}

	/**
	 * @param buildingname
	 *            the buildingname to set
	 */
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserPlot [id=" + id + ", uid=" + uid + ",plotname=" + plotname + ", plotid=" + plotid
				+ ", buildingname=" + buildingname + ", room=" + room + "]";
	}

	/**
	 * 
	 */
	public UserPlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param uid
	 * @param plotid
	 * @param plotname
	 * @param buildingname
	 * @param room
	 */
	public UserPlot(int id, String uid, String plotid, String plotname, String buildingname, String room) {
		super();
		this.id = id;
		this.uid = uid;
		this.plotid = plotid;
		this.plotname = plotname;
		this.buildingname = buildingname;
		this.room = room;
	}

}
