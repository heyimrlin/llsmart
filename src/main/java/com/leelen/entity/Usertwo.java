/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日下午3:30:10
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
@Table(name="usertwo")
public class Usertwo {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="uid", nullable = false)
	private String uid;
	
	@Column(name="plotid", nullable = false)
	private String plotid;
	
	@Column(name="familyrole", nullable = false)
	private String familyrole;//家庭角色(业主/成员)
	
	@Column(name="note")
	private String note;

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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * @return the familyrole
	 */
	public String getFamilyrole() {
		return familyrole;
	}

	/**
	 * @param familyrole the familyrole to set
	 */
	public void setFamilyrole(String familyrole) {
		this.familyrole = familyrole;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}
