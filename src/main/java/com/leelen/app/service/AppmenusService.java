/**
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.Appmenus;

/**
 * @author xiaoxl by male
 * @time 2018年6月26日下午2:00:27
 * @class AppmenusService.java
 */
public interface AppmenusService {

	List<Appmenus> getAppmenusByRoleid(String roleid);
}
