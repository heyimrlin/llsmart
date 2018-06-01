/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月2日下午1:43:30
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.io.Serializable;

/**
 * @author xiaoxl
 *
 */
public class Response implements Serializable {

    /**
	 * @时间:20182018年5月2日下午1:43:53
	 * @param:param
	 * @描述:TODO
	 */
	private static final long serialVersionUID = 1L;

	private String code = "0";

    private String message;

    private Serializable data;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Serializable getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Serializable data) {
        this.data = data;
    }

    public void tokenLoseEfficacy(){
        this.code="401";
        this.message="身份验证失败!";
    }
    
    
    

	/**
	 * 
	 */
	public Response() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param message
	 * @param data
	 */
	public Response(String code, String message, Serializable data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
