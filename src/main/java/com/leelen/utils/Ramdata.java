/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日下午4:58:52
 * @包名:com.leelen.utils
 * @描述:TODO
 */
package com.leelen.utils;

import java.util.Random;

/**
 * @author xiaoxl
 *
 */
public class Ramdata {

	public static String ramda() {

		String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < 10; j++) {
			flag.append(sources.charAt(rand.nextInt(9)) + "");
		}
		System.out.println(flag.toString());
		return flag.toString();
	}

	public static void main(String[] args) {
			String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
			Random rand = new Random();
			StringBuffer flag = new StringBuffer();
			for (int j = 0; j < 10; j++) {
				flag.append(sources.charAt(rand.nextInt(9)) + "");
			}
			System.out.println(flag.toString());
	}
	
	
	public static String ramdaSw(int num) {

		String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < num; j++) {
			flag.append(sources.charAt(rand.nextInt(9)) + "");
		}
		System.out.println(flag.toString());
		return flag.toString();
	}
}
