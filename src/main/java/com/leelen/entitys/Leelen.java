/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午3:00:25
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entitys;

/**
 * @author xiaoxl
 *
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:leelen.properties")
@ConfigurationProperties(prefix = "leelen")
public class Leelen {

	private String name;
	private String smart;

	private String smskey;

	private String syskey;

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
	 * @return the smart
	 */
	public String getSmart() {
		return smart;
	}

	/**
	 * @param smart
	 *            the smart to set
	 */
	public void setSmart(String smart) {
		this.smart = smart;
	}

	public String getSmskey() {
		return smskey;
	}

	public void setSmskey(String smskey) {
		this.smskey = smskey;
	}

	public String getSyskey() {
		return syskey;
	}

	public void setSyskey(String syskey) {
		this.syskey = syskey;
	}

}
