/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月8日上午11:30:39
 * @包名:com.leelen.entity
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
 * @author xiaoxl
 *
 */
@Entity
@Table(name = "sh_area", schema = "llsmart", catalog = "")
public class Sharea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Basic
	@Column(name = "pid")
	private int pid;

	@Basic
	@Column(name = "shortname")
	private String shortname;

	@Basic
	@Column(name = "name")
	private String name;

	@Basic
	@Column(name = "merger_name")
	private String mergername;

	@Basic
	@Column(name = "level")
	private Integer level;

	@Basic
	@Column(name = "pinyin")
	private String pinyin;

	@Basic
	@Column(name = "code")
	private String code;

	@Basic
	@Column(name = "zip_code")
	private String zip_code;

	@Basic
	@Column(name = "first")
	private String first;

	@Basic
	@Column(name = "lng")
	private String lng;

	@Basic
	@Column(name = "lat")
	private String lat;

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
	 * @return the pid
	 */
	@JsonIgnore
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the shortname
	 */
	public String getShortname() {
		return shortname;
	}

	/**
	 * @param shortname
	 *            the shortname to set
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the merger_name
	 */
	public String getMergername() {
		return mergername;
	}

	/**
	 * @param merger_name
	 *            the merger_name to set
	 */
	public void setMerger_name(String mergername) {
		this.mergername = mergername;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the pinyin
	 */
	@JsonIgnore
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin
	 *            the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}

	/**
	 * @param zip_code
	 *            the zip_code to set
	 */
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * @return the first
	 */
	@JsonIgnore
	public String getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 *            the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * 
	 */
	public Sharea() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param pid
	 * @param shortname
	 * @param name
	 * @param merger_name
	 * @param level
	 * @param pinyin
	 * @param code
	 * @param zip_code
	 * @param first
	 * @param lng
	 * @param lat
	 */
	public Sharea(int id, int pid, String shortname, String name, String mergername, Integer level, String pinyin,
			String code, String zip_code, String first, String lng, String lat) {
		super();
		this.id = id;
		this.pid = pid;
		this.shortname = shortname;
		this.name = name;
		this.mergername = mergername;
		this.level = level;
		this.pinyin = pinyin;
		this.code = code;
		this.zip_code = zip_code;
		this.first = first;
		this.lng = lng;
		this.lat = lat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sharea [id=" + id + ", pid=" + pid + ", shortname=" + shortname + ", name=" + name + ", mergername="
				+ mergername + ", level=" + level + ", pinyin=" + pinyin + ", code=" + code + ", zip_code=" + zip_code
				+ ", first=" + first + ", lng=" + lng + ", lat=" + lat + "]";
	}

}
