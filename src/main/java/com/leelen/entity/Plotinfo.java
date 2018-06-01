/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月26日下午3:11:00
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xiaoxl
 *
 */
@Entity
@Table(name="plotinfo")
public class Plotinfo {

	@Id
    @GeneratedValue
	private int id;
	@Column(name="plotid", nullable = false)
	private String plotid;// 
	@Column(name="plotname", nullable = false)
	private String plotname;// 
	@Column(name="plotelementnum")
	private int plotelementnum;// 
	@Column(name="plotroomnum")
	private int plotroomnum;// 
	@Column(name="plotofcity")
	private String plotofcity;// 
	@Column(name="plotcharge")
	private String plotcharge;// 
	@Column(name="plottime")
	private String plottime;// 
	@Column(name="plotcreater")
	private String plotcreater;// 
	@Column(name="plotmanager")
	private String plotmanager;// 
	@Column(name="plotcall")
	private String plotcall;// 
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param plotid the plotid to set
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
	 * @param plotname the plotname to set
	 */
	public void setPlotname(String plotname) {
		this.plotname = plotname;
	}
	/**
	 * @return the plotelementnum
	 */
	public int getPlotelementnum() {
		return plotelementnum;
	}
	/**
	 * @param plotelementnum the plotelementnum to set
	 */
	public void setPlotelementnum(int plotelementnum) {
		this.plotelementnum = plotelementnum;
	}
	/**
	 * @return the plotroomnum
	 */
	public int getPlotroomnum() {
		return plotroomnum;
	}
	/**
	 * @param plotroomnum the plotroomnum to set
	 */
	public void setPlotroomnum(int plotroomnum) {
		this.plotroomnum = plotroomnum;
	}
	/**
	 * @return the plotofcity
	 */
	public String getPlotofcity() {
		return plotofcity;
	}
	/**
	 * @param plotofcity the plotofcity to set
	 */
	public void setPlotofcity(String plotofcity) {
		this.plotofcity = plotofcity;
	}
	/**
	 * @return the plotcharge
	 */
	public String getPlotcharge() {
		return plotcharge;
	}
	/**
	 * @param plotcharge the plotcharge to set
	 */
	public void setPlotcharge(String plotcharge) {
		this.plotcharge = plotcharge;
	}
	/**
	 * @return the plottime
	 */
	public String getPlottime() {
		return plottime;
	}
	/**
	 * @param plottime the plottime to set
	 */
	public void setPlottime(String plottime) {
		this.plottime = plottime;
	}
	/**
	 * @return the plotcreater
	 */
	public String getPlotcreater() {
		return plotcreater;
	}
	/**
	 * @param plotcreater the plotcreater to set
	 */
	public void setPlotcreater(String plotcreater) {
		this.plotcreater = plotcreater;
	}
	/**
	 * @return the plotmanager
	 */
	public String getPlotmanager() {
		return plotmanager;
	}
	/**
	 * @param plotmanager the plotmanager to set
	 */
	public void setPlotmanager(String plotmanager) {
		this.plotmanager = plotmanager;
	}
	/**
	 * @return the plotcall
	 */
	public String getPlotcall() {
		return plotcall;
	}
	/**
	 * @param plotcall the plotcall to set
	 */
	public void setPlotcall(String plotcall) {
		this.plotcall = plotcall;
	}
	
}
