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
@Table(name = "room", schema = "llsmart", catalog = "")
public class Room implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "roomid", nullable = false)
	private String roomid;// 房间id

	@Basic
	@Column(name = "roomname", nullable = false)
	private String roomname;// 房间名称

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 创建时间

	@Basic
	@Column(name = "status", nullable = false)
	private int status;// 房间状态

	@Basic
	@Column(name = "creater", nullable = false)
	private String creater;// 房间创建人

	@Basic
	@Column(name = "unitid", nullable = false)
	private String unitid;// 单元id

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

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
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
	public Room() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param roomid
	 * @param roomname
	 * @param createtime
	 * @param status
	 * @param creater
	 * @param unitid
	 * @param plotid
	 */
	public Room(int id, String roomid, String roomname, String createtime, int status, String creater, String unitid,
			String plotid) {
		this.id = id;
		this.roomid = roomid;
		this.roomname = roomname;
		this.createtime = createtime;
		this.status = status;
		this.creater = creater;
		this.unitid = unitid;
		this.plotid = plotid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creater == null) ? 0 : creater.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + id;
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((roomid == null) ? 0 : roomid.hashCode());
		result = prime * result + ((roomname == null) ? 0 : roomname.hashCode());
		result = prime * result + status;
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
		Room other = (Room) obj;
		if (creater == null) {
			if (other.creater != null)
				return false;
		} else if (!creater.equals(other.creater))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id != other.id)
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (roomid == null) {
			if (other.roomid != null)
				return false;
		} else if (!roomid.equals(other.roomid))
			return false;
		if (roomname == null) {
			if (other.roomname != null)
				return false;
		} else if (!roomname.equals(other.roomname))
			return false;
		if (status != other.status)
			return false;
		if (unitid == null) {
			if (other.unitid != null)
				return false;
		} else if (!unitid.equals(other.unitid))
			return false;
		return true;
	}

}
