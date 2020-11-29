package com.kevin.spring.application.event.sample.consts;

/**
 * http返回码
 *
 * @author wangyong
 */
public enum HttpCodeConsts {

  SUCCESS("200", "成功"),

  FAIL("500", "失败");

  /**
   * 响应码、描述
   */
  private final String code, message;


  HttpCodeConsts(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "HttpCodeConsts{" + "code='" + code + '\''
        + ", message='" + message + '\''
        + '}';
  }
}
