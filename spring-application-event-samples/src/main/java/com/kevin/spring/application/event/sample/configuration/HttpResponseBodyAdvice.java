package com.kevin.spring.application.event.sample.configuration;

import com.kevin.spring.application.event.sample.common.http.HttpResult;
import com.kevin.spring.application.event.sample.consts.HttpCodeConsts;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 包装统一返回
 *
 * @author wangyong
 */
@ControllerAdvice
public class HttpResponseBodyAdvice implements ResponseBodyAdvice<Object> {

  private static final Logger logger = LoggerFactory.getLogger(HttpResponseBodyAdvice.class);


  @Override
  public boolean supports(MethodParameter methodParameter,
      Class<? extends HttpMessageConverter<?>> aClass) {
    return MappingJackson2HttpMessageConverter.class.isAssignableFrom(aClass);
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
      Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse) {
    if (body == null) {
      return body;
    }
    if (body instanceof HttpResult || body instanceof String) {
      return body;
    } else {
      HttpResult result = new HttpResult();
      result.setCode(HttpCodeConsts.SUCCESS.getCode());
      result.setData(body);
      body = result;
      return body;
    }
  }
}
