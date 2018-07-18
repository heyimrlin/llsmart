/**
 * @包名:com.leelen.myscheduled
 * @描述:TODO
 */
package com.leelen.myscheduled;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

/**
 * @author xiaoxl by male
 * @time 2018年6月27日下午5:21:21
 * @class MySchedules.java
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Schedules(value = { @Scheduled })
public @interface MySchedules {

	Scheduled[] value();
}
