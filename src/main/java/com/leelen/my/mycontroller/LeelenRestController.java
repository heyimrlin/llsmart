/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:28:40
 * @包名:com.leelen.my.mycontroller
 * @描述:TODO
 */
package com.leelen.my.mycontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaoxl
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface LeelenRestController {

	String value() default "";

	String msg() default "";
}
