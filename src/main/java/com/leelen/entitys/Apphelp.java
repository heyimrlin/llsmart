/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午3:33:43
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

/**
 * @author xiaoxl APP帮助
 *
 */
@Entity
@Table(name = "apphelp", schema = "llsmart", catalog = "")
public class Apphelp implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 自增长ID

	@Basic
	@Column(name = "helptype", nullable = false)
	private String helptype;// 帮助类型 0表示常见问题 1表示注意事项 3其它

	@Basic
	@Column(name = "title", nullable = false)
	private String title;// 标题

	@Basic
	@Column(name = "content", nullable = false)
	private String content;// 内容

	@Basic
	@Column(name = "status", nullable = false)
	private int status;// 状态

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
	 * @return the helptype
	 */
	public String getHelptype() {
		return helptype;
	}

	/**
	 * @param helptype
	 *            the helptype to set
	 */
	public void setHelptype(String helptype) {
		this.helptype = helptype;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Apphelp [id=" + id + ", helptype=" + helptype + ", title=" + title + ", content=" + content
				+ ", status=" + status + "]";
	}

	/**
	 * 
	 */
	public Apphelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param helptype
	 * @param title
	 * @param content
	 * @param status
	 */
	public Apphelp(int id, String helptype, String title, String content, int status) {
		super();
		this.id = id;
		this.helptype = helptype;
		this.title = title;
		this.content = content;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((helptype == null) ? 0 : helptype.hashCode());
		result = prime * result + id;
		result = prime * result + status;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Apphelp other = (Apphelp) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (helptype == null) {
			if (other.helptype != null)
				return false;
		} else if (!helptype.equals(other.helptype))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
