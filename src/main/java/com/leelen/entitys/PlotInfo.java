/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午5:00:17
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
 * @author xiaoxl 小区信息表
 *
 */
@Entity
@Table(name = "plotinfo", schema = "llsmart", catalog = "")
public class PlotInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区ID，唯一标识

	@Basic
	@Column(name = "plotname", nullable = false)
	private String plotname;// 小区名称

	@Basic
	@Column(name = "buildingname", nullable = false)
	private String buildingname;// 单元名称

	@Basic
	@Column(name = "room", nullable = false)
	private String room;// 房间名称

	@Basic
	@Column(name = "plotofcity", nullable = false)
	private String plotofcity;// 所在城市

	@Basic
	@Column(name = "buildingtype", nullable = false)
	private int buildingtype;// 单元类型 :楼幢、围墙

	@Basic
	@Column(name = "floornum", nullable = false)
	private int floornum;// 楼层数(楼幢)

	@Basic
	@Column(name = "plotcreater", nullable = false)
	private String plotcreater;// 小区创建人

	@Basic
	@Column(name = "plotcall", nullable = false)
	private String plotcall;// 小区联系方式

	@Basic
	@Column(name = "plottime", nullable = false)
	private String plottime;// 小区创建时间

	@Basic
	@Column(name = "plotstatus", nullable = false)
	private int plotstatus;// 小区状态

	@Basic
	@Column(name = "issupportadduser", nullable = false)
	private int issupportadduser;// 是否支持业主添加成员 0标识可以 1标识不可以

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

	/**
	 * @return the plotofcity
	 */
	public String getPlotofcity() {
		return plotofcity;
	}

	/**
	 * @param plotofcity
	 *            the plotofcity to set
	 */
	public void setPlotofcity(String plotofcity) {
		this.plotofcity = plotofcity;
	}

	/**
	 * @return the buildingtype
	 */
	public int getBuildingtype() {
		return buildingtype;
	}

	/**
	 * @param buildingtype
	 *            the buildingtype to set
	 */
	public void setBuildingtype(int buildingtype) {
		this.buildingtype = buildingtype;
	}

	/**
	 * @return the floornum
	 */
	public int getFloornum() {
		return floornum;
	}

	/**
	 * @param floornum
	 *            the floornum to set
	 */
	public void setFloornum(int floornum) {
		this.floornum = floornum;
	}

	/**
	 * @return the plotcreater
	 */
	public String getPlotcreater() {
		return plotcreater;
	}

	/**
	 * @param plotcreater
	 *            the plotcreater to set
	 */
	public void setPlotcreater(String plotcreater) {
		this.plotcreater = plotcreater;
	}

	/**
	 * @return the plotcall
	 */
	public String getPlotcall() {
		return plotcall;
	}

	/**
	 * @param plotcall
	 *            the plotcall to set
	 */
	public void setPlotcall(String plotcall) {
		this.plotcall = plotcall;
	}

	/**
	 * @return the plottime
	 */
	public String getPlottime() {
		return plottime;
	}

	/**
	 * @param plottime
	 *            the plottime to set
	 */
	public void setPlottime(String plottime) {
		this.plottime = plottime;
	}

	/**
	 * @return the plotstatus
	 */
	@JsonIgnore
	public int getPlotstatus() {
		return plotstatus;
	}

	/**
	 * @param plotstatus
	 *            the plotstatus to set
	 */
	public void setPlotstatus(int plotstatus) {
		this.plotstatus = plotstatus;
	}

	/**
	 * @return the issupportadduser
	 */
	public int getIssupportadduser() {
		return issupportadduser;
	}

	/**
	 * @param issupportadduser
	 *            the issupportadduser to set
	 */
	public void setIssupportadduser(int issupportadduser) {
		this.issupportadduser = issupportadduser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlotInfo [id=" + id + ", plotid=" + plotid + ", plotname=" + plotname + ", buildingname=" + buildingname
				+ ", room=" + room + ", plotofcity=" + plotofcity + ", buildingtype=" + buildingtype + ", floornum="
				+ floornum + ", plotcreater=" + plotcreater + ", plotcall=" + plotcall + ", plottime=" + plottime
				+ ", plotstatus=" + plotstatus + ", issupportadduser=" + issupportadduser + "]";
	}

	/**
	 * 
	 */
	public PlotInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param plotid
	 * @param plotname
	 * @param buildingname
	 * @param room
	 * @param plotofcity
	 * @param buildingtype
	 * @param floornum
	 * @param plotcreater
	 * @param plotcall
	 * @param plottime
	 * @param plotstatus
	 * @param issupportadduser
	 */
	public PlotInfo(int id, String plotid, String plotname, String buildingname, String room, String plotofcity,
			int buildingtype, int floornum, String plotcreater, String plotcall, String plottime, int plotstatus,
			int issupportadduser) {
		super();
		this.id = id;
		this.plotid = plotid;
		this.plotname = plotname;
		this.buildingname = buildingname;
		this.room = room;
		this.plotofcity = plotofcity;
		this.buildingtype = buildingtype;
		this.floornum = floornum;
		this.plotcreater = plotcreater;
		this.plotcall = plotcall;
		this.plottime = plottime;
		this.plotstatus = plotstatus;
		this.issupportadduser = issupportadduser;
	}

}
