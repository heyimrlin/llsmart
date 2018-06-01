/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月10日上午11:36:13
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

/**
 * @author xiaoxl
 *
 */
public class RespEntity {

	private int code;
    private String msg;
    private Object data;

    public RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }
}
