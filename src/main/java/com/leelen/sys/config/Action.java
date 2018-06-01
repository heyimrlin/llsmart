package com.leelen.sys.config;

/**
 * @author 肖杏林
 * @date 2017年2月14日 下午5:58:19
 * @param 
 * @Company 上邦开发
 */
public abstract interface Action
{
  public static final String ERROR = "error";
  public static final String SUCCESS = "success";
  public static final String INPUT = "input";
  public static final String LOGIN = "login";
  public static final String NONE = "none";

  public abstract String execute()
    throws Exception;
}