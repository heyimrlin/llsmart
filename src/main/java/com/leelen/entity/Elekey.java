/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月28日下午3:05:09
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
 * 口令(电子钥匙)实体类
 */
@Entity
@Table(name="ele_key")
public class Elekey {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int  id;//编号
	
	@Column(name="uid")
	private String uid;//请求生成口令人
	
	@Column(name="oid")
	private String oid;//口令生成ID标识
	
	@Column(name="menjingid")
	private String menjingid;//门禁ID
	
	@Column(name="electronickey")
	private String electronickey;//口令
	
	@Column(name="isuse")
	private int isuse;//是否已用
	
	@Column(name="validtime")
	private String validtime;//有效时间
	
	@Column(name="createtime")
	private String createtime;//生成时间

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
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return the menjingid
	 */
	public String getMenjingid() {
		return menjingid;
	}

	/**
	 * @param menjingid the menjingid to set
	 */
	public void setMenjingid(String menjingid) {
		this.menjingid = menjingid;
	}

	/**
	 * @return the electronickey
	 */
	public String getElectronickey() {
		return electronickey;
	}

	/**
	 * @param electronickey the electronickey to set
	 */
	public void setElectronickey(String electronickey) {
		this.electronickey = electronickey;
	}

	/**
	 * @return the isuse
	 */
	public int getIsuse() {
		return isuse;
	}

	/**
	 * @param isuse the isuse to set
	 */
	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	/**
	 * @return the validtime
	 */
	public String getValidtime() {
		return validtime;
	}

	/**
	 * @param validtime the validtime to set
	 */
	public void setValidtime(String validtime) {
		this.validtime = validtime;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 
	 */
	public Elekey() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param uid
	 * @param oid
	 * @param menjingid
	 * @param electronickey
	 * @param isuse
	 * @param validtime
	 * @param createtime
	 */
	public Elekey(int id, String uid, String oid, String menjingid, String electronickey, int isuse,
			String validtime, String createtime) {
		super();
		this.id = id;
		this.uid = uid;
		this.oid = oid;
		this.menjingid = menjingid;
		this.electronickey = electronickey;
		this.isuse = isuse;
		this.validtime = validtime;
		this.createtime = createtime;
	}
	
	
	
}
