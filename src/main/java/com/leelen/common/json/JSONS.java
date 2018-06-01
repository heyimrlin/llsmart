/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月4日下午3:21:54
 * @包名:com.leelen.common.json
 * @描述:TODO
 */
package com.leelen.common.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaoxl
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONS {

	JSON [] value();
}
