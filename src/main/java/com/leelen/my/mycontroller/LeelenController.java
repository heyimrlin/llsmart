/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:25:18
 * @包名:com.leelen.my.mycontroller
 * @描述:TODO
 */
package com.leelen.my.mycontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * @author xiaoxl
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface LeelenController {

	String value() default "";

	String msg() default "";
}
