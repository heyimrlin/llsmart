package com.leelen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apphelp")
public class Apphelp {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private int problemtype;
	
	@Column(nullable = false)
	private String problemname;
	
	@Column(nullable = true)
	private String problemexplain;
			
	private Date createtime;
		
	private int isshow;
		
	private String createer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProblemtype() {
		return problemtype;
	}

	public void setProblemtype(int problemtype) {
		this.problemtype = problemtype;
	}

	public String getProblemname() {
		return problemname;
	}

	public void setProblemname(String problemname) {
		this.problemname = problemname;
	}

	public String getProblemexplain() {
		return problemexplain;
	}

	public void setProblemexplain(String problemexplain) {
		this.problemexplain = problemexplain;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public String getCreateer() {
		return createer;
	}

	public void setCreateer(String createer) {
		this.createer = createer;
	}

	@Override
	public String toString() {
		return "Apphelp [id=" + id + ", problemtype=" + problemtype + ", problemname=" + problemname
				+ ", problemexplain=" + problemexplain + ", createtime=" + createtime + ", isshow=" + isshow
				+ ", createer=" + createer + "]";
	}

	public Apphelp(int id, int problemtype, String problemname, String problemexplain, Date createtime, int isshow,
			String createer) {
		super();
		this.id = id;
		this.problemtype = problemtype;
		this.problemname = problemname;
		this.problemexplain = problemexplain;
		this.createtime = createtime;
		this.isshow = isshow;
		this.createer = createer;
	}

	public Apphelp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
