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
@Table(name = "plot", schema = "llsmart", catalog = "")
public class Plot implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "plotid", nullable = false)
	private String plotid;// 小区id

	@Basic
	@Column(name = "plotname", nullable = false)
	private String plotname;// 小区名称

	@Basic
	@Column(name = "plotarea", nullable = false)
	private String plotarea;// 小区所在地

	@Basic
	@Column(name = "plotsatus", nullable = false)
	private int plotsatus;// 小区状态

	@Basic
	@Column(name = "createtime", nullable = false)
	private String createtime;// 小区创建时间

	@Basic
	@Column(name = "creater", nullable = false)
	private String creater;// 小区创建人

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

	public String getPlotid() {
		return plotid;
	}

	public void setPlotid(String plotid) {
		this.plotid = plotid;
	}

	public String getPlotname() {
		return plotname;
	}

	public void setPlotname(String plotname) {
		this.plotname = plotname;
	}

	public String getPlotarea() {
		return plotarea;
	}

	public void setPlotarea(String plotarea) {
		this.plotarea = plotarea;
	}

	public int getPlotsatus() {
		return plotsatus;
	}

	public void setPlotsatus(int plotsatus) {
		this.plotsatus = plotsatus;
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

	/**
	 * 
	 */
	public Plot() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param plotid
	 * @param plotname
	 * @param plotarea
	 * @param plotsatus
	 * @param createtime
	 * @param creater
	 */
	public Plot(int id, String plotid, String plotname, String plotarea, int plotsatus, String createtime,
			String creater) {
		this.id = id;
		this.plotid = plotid;
		this.plotname = plotname;
		this.plotarea = plotarea;
		this.plotsatus = plotsatus;
		this.createtime = createtime;
		this.creater = creater;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creater == null) ? 0 : creater.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + id;
		result = prime * result + ((plotarea == null) ? 0 : plotarea.hashCode());
		result = prime * result + ((plotid == null) ? 0 : plotid.hashCode());
		result = prime * result + ((plotname == null) ? 0 : plotname.hashCode());
		result = prime * result + plotsatus;
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
		Plot other = (Plot) obj;
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
		if (plotarea == null) {
			if (other.plotarea != null)
				return false;
		} else if (!plotarea.equals(other.plotarea))
			return false;
		if (plotid == null) {
			if (other.plotid != null)
				return false;
		} else if (!plotid.equals(other.plotid))
			return false;
		if (plotname == null) {
			if (other.plotname != null)
				return false;
		} else if (!plotname.equals(other.plotname))
			return false;
		if (plotsatus != other.plotsatus)
			return false;
		return true;
	}

}
