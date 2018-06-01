/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:51:51
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
 * @author xiaoxl 卡、小区关联表
 *
 */
@Entity
@Table(name = "cardplot", schema = "llsmart", catalog = "")
public class CardPlot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "cardno", nullable = false)
	private String cardno;// 门禁卡号

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区编号

	@Basic
	@Column(name = "buildingname", nullable = false)
	private String buildingname;// 小区单元名称

	@Basic
	@Column(name = "room", nullable = false)
	private String room;// 房间名称

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
	 * @return the cardno
	 */
	public String getCardno() {
		return cardno;
	}

	/**
	 * @param cardno
	 *            the cardno to set
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
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
		return "CardPlot [id=" + id + ", cardno=" + cardno + ", plotid=" + plotid + ", buildingname=" + buildingname
				+ ", room=" + room + "]";
	}

	/**
	 * 
	 */
	public CardPlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param cardno
	 * @param plotid
	 * @param buildingname
	 * @param room
	 */
	public CardPlot(int id, String cardno, String plotid, String buildingname, String room) {
		super();
		this.id = id;
		this.cardno = cardno;
		this.plotid = plotid;
		this.buildingname = buildingname;
		this.room = room;
	}

}
