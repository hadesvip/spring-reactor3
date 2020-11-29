package com.kevin.spring.application.event.sample.common.http;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 * 请求结果
 *
 * @author wangyong
 */
@Data
public class HttpResult<T> {

  private String code;

  private String message;

  private T data;

  private String accessDateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

}
