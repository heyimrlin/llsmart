/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月28日上午10:28:36
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="t_logger_infos")
public class LoggerEntity implements Serializable {

	/**
	 * @时间:20182018年4月28日上午10:29:18
	 * @param:param
	 * @描述:TODO
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ali_id")
	private long id;//编号
	
	@Column(name="ali_client_ip")
	private String clienIp;
	
	@Column(name="ali_uri")
	private String uri;
	
	@Column(name="ali_type")
	private String type;
	
	@Column(name="ali_method")
	private String method;
	
	@Column(name="ali_param_data")
	private String paramData;
	
	@Column(name="ali_session_id")
	private String sessionId;
	
	@Column(name="ali_time")
	private Timestamp time;
	
	@Column(name="ali_return_time")
	private String returnTime;
	
	@Column(name="ali_return_data")
	private String returnData;
	
	@Column(name="ali_http_status_code")
	private String httpStatusCode;
	
	@Column(name="ali_time_consuming")
	private String timeConsuming;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the clienIp
	 */
	public String getClienIp() {
		return clienIp;
	}

	/**
	 * @param clienIp the clienIp to set
	 */
	public void setClienIp(String clienIp) {
		this.clienIp = clienIp;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the paramData
	 */
	public String getParamData() {
		return paramData;
	}

	/**
	 * @param paramData the paramData to set
	 */
	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * @return the returnTime
	 */
	public String getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime the returnTime to set
	 */
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * @return the returnData
	 */
	public String getReturnData() {
		return returnData;
	}

	/**
	 * @param returnData the returnData to set
	 */
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	/**
	 * @return the httpStatusCode
	 */
	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @param httpStatusCode the httpStatusCode to set
	 */
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * @return the timeConsuming
	 */
	public String getTimeConsuming() {
		return timeConsuming;
	}

	/**
	 * @param timeConsuming the timeConsuming to set
	 */
	public void setTimeConsuming(String timeConsuming) {
		this.timeConsuming = timeConsuming;
	}
	
	
	
	

}
