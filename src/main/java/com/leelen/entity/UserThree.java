/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日下午4:04:59
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
@Table(name="userthree")
public class UserThree {

	@Id
    @GeneratedValue
    private Integer id;
	
	@Column(name="token_id",nullable = false)
    private String tokenid;
	
    @Column(name="token_value", nullable = false)
    private String tokenvalue; 
    
    @Column(name="end_time",nullable = false)
    private String endtime;
    
    @Column(nullable = false)
    private String uid;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the token_id
	 */
	public String getToken_id() {
		return tokenid;
	}

	/**
	 * @param token_id the token_id to set
	 */
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	/**
	 * @return the token_value
	 */
	public String getToken_value() {
		return tokenvalue;
	}

	/**
	 * @param token_value the token_value to set
	 */
	public void setTokenvalue(String tokenvalue) {
		this.tokenvalue = tokenvalue;
	}

	/**
	 * @return the end_time
	 */
	public String getEnd_time() {
		return endtime;
	}

	/**
	 * @param end_time the end_time to set
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	@Override
	public String toString() {
		return "UserThree [id=" + id + ", tokenid=" + tokenid + ", tokenvalue=" + tokenvalue + ", endtime="
				+ endtime + ", uid=" + uid + "]";
	}
    
    
    
    
}
