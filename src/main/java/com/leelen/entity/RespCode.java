/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月10日上午11:36:34
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

/**
 * @author xiaoxl
 *
 */
public enum RespCode {

	SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
