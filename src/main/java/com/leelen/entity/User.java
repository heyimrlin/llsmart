package com.leelen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String uid;
    @Column(nullable = false, unique = true)
    private String realname;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = true)
    private String password;
    @Column(nullable = false)
    private String tell;
    
    @Column(nullable = true)
    private String email;
    
    @Column(nullable = true)
    private String useable;
    @Column(nullable = true)
    private String roleid;
    @Column(nullable = true)
    private String addtime;
    @Column(nullable = true)
    private String lastlogintime;
    @Column(nullable = true)
    private String loginip;
    @Column(nullable = true)
    private String online;
    @Column(nullable = true)
    private String plotid;
    @Column(nullable = true)
    private String unit;
    @Column(nullable = true)
    private String house;

    @JsonIgnore
    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
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
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	//@Basic
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}

	/**
	 * @return the email
	 */
	@JsonIgnore
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the useable
	 */
	@JsonIgnore
	public String getUseable() {
		return useable;
	}

	/**
	 * @param useable the useable to set
	 */
	public void setUseable(String useable) {
		this.useable = useable;
	}

	/**
	 * @return the roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the addtime
	 */
	@JsonIgnore
	public String getAddtime() {
		return addtime;
	}

	/**
	 * @param addtime the addtime to set
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	/**
	 * @return the lastlogintime
	 */
	@JsonIgnore
	public String getLastlogintime() {
		return lastlogintime;
	}

	/**
	 * @param lastlogintime the lastlogintime to set
	 */
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	/**
	 * @return the loginip
	 */
	@JsonIgnore
	public String getLoginip() {
		return loginip;
	}

	/**
	 * @param loginip the loginip to set
	 */
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	/**
	 * @return the online
	 */
	@JsonIgnore
	public String getOnline() {
		return online;
	}

	/**
	 * @param online the online to set
	 */
	public void setOnline(String online) {
		this.online = online;
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
	 * @return the unit
	 */
	@JsonIgnore
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the house
	 */
	@JsonIgnore
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uid=" + uid + ", realname=" + realname + ", username=" + username + ", password="
				+ password + ", tell=" + tell + ", email=" + email + ", useable=" + useable + ", roleid=" + roleid
				+ ", addtime=" + addtime + ", lastlogintime=" + lastlogintime + ", loginip=" + loginip + ", online="
				+ online + ", plotid=" + plotid + ", unit=" + unit + ", house=" + house + "]";
	}

    
}
