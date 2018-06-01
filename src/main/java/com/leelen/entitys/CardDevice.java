/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:47:30
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
 * @author xiaoxl 卡、设备表
 *
 */
@Entity
@Table(name = "carddevice", schema = "llsmart", catalog = "")
public class CardDevice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "cardno", nullable = false)
	private String cardno;// 门禁卡号

	@Basic
	@Column(name = "deviceid", nullable = false)
	private String deviceid;// 设备号

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
	 * @return the deviceid
	 */
	public String getDeviceid() {
		return deviceid;
	}

	/**
	 * @param deviceid
	 *            the deviceid to set
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CardDevice [id=" + id + ", cardno=" + cardno + ", deviceid=" + deviceid + "]";
	}

	/**
	 * 
	 */
	public CardDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param cardno
	 * @param deviceid
	 */
	public CardDevice(int id, String cardno, String deviceid) {
		super();
		this.id = id;
		this.cardno = cardno;
		this.deviceid = deviceid;
	}

}
