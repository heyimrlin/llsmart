/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月26日下午8:08:03
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author xiaoxl
 *
 */
@Entity
@Table(name="plotadv")
public class Plotadv {

	@Id
    @GeneratedValue
	private int id;
	@Column(name="advid", nullable = false)
	private String advid;// 
	@Column(name="plotid", nullable = false)
	private String plotid;// 
	@Column(name="authoer")
	private String authoer;// 
	@Column(name="advconent")
	private String advconent;// 
	@Column(name="advimgurl")
	private String advimgurl;// 
	@Column(name="advtype")
	private String advtype;// 
	@Column(name="showtype")
	private String showtype;//
	@Column(name="isshow")
	private int isshow;// 
	@Column(name="showtime")
	private String showtime;//
	/**
	 * @return the id
	 */
	@JsonIgnore
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
	 * @return the advid
	 */
	@JsonIgnore
	public String getAdvid() {
		return advid;
	}
	/**
	 * @param advid the advid to set
	 */
	public void setAdvid(String advid) {
		this.advid = advid;
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
	 * @return the authoer
	 */
	@JsonIgnore
	public String getAuthoer() {
		return authoer;
	}
	/**
	 * @param authoer the authoer to set
	 */
	public void setAuthoer(String authoer) {
		this.authoer = authoer;
	}
	/**
	 * @return the advconent
	 */
	public String getAdvconent() {
		return advconent;
	}
	/**
	 * @param advconent the advconent to set
	 */
	public void setAdvconent(String advconent) {
		this.advconent = advconent;
	}
	/**
	 * @return the advimgurl
	 */
	public String getAdvimgurl() {
		return advimgurl;
	}
	/**
	 * @param advimgurl the advimgurl to set
	 */
	public void setAdvimgurl(String advimgurl) {
		this.advimgurl = advimgurl;
	}
	/**
	 * @return the advtype
	 */
	@JsonIgnore
	public String getAdvtype() {
		return advtype;
	}
	/**
	 * @param advtype the advtype to set
	 */
	public void setAdvtype(String advtype) {
		this.advtype = advtype;
	}
	/**
	 * @return the showtype
	 */
	@JsonIgnore
	public String getShowtype() {
		return showtype;
	}
	/**
	 * @param showtype the showtype to set
	 */
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	/**
	 * @return the isshow
	 */
	@JsonIgnore
	public int getIsshow() {
		return isshow;
	}
	/**
	 * @param isshow the isshow to set
	 */
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	/**
	 * @return the showtime
	 */
	public String getShowtime() {
		return showtime;
	}
	/**
	 * @param showtime the showtime to set
	 */
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	/**
	 * 
	 */
	public Plotadv() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param advid
	 * @param plotid
	 * @param authoer
	 * @param advconent
	 * @param advimgurl
	 * @param advtype
	 * @param showtype
	 * @param isshow
	 * @param showtime
	 */
	public Plotadv(int id, String advid, String plotid, String authoer, String advconent, String advimgurl,
			String advtype, String showtype, int isshow, String showtime) {
		super();
		this.id = id;
		this.advid = advid;
		this.plotid = plotid;
		this.authoer = authoer;
		this.advconent = advconent;
		this.advimgurl = advimgurl;
		this.advtype = advtype;
		this.showtype = showtype;
		this.isshow = isshow;
		this.showtime = showtime;
	}
	
	
	
}
