/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:51:51
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
 * @author xiaoxl 卡、小区关联表
 *
 */
@Entity
@Table(name = "cardplot", schema = "llsmart", catalog = "")
public class CardPlot implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingname == null) ? 0 : buildingname.hashCode());
		result = prime * result + ((cardno == null) ? 0 : cardno.hashCode());
		result = prime * result + id;
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		CardPlot other = (CardPlot) obj;
		if (buildingname == null) {
			if (other.buildingname != null)
				return false;
		} else if (!buildingname.equals(other.buildingname))
			return false;
		if (cardno == null) {
			if (other.cardno != null)
				return false;
		} else if (!cardno.equals(other.cardno))
			return false;
		if (id != other.id)
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

}
