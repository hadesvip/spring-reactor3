//package com.kevin.spring.application.event.sample.application.publisher;
//
//import com.kevin.spring.application.event.sample.application.event.EmailApplicationEvent;
//import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
//import java.util.List;
//import javax.annotation.Resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailPublisher {
//
//  private static final Logger logger = LoggerFactory.getLogger(EmailPublisher.class);
//
//
//  @Resource
//  private ApplicationEventPublisher applicationEventPublisher;
//
//
//  /**
//   * 发布事件
//   */
//  public void publishEvent(List<EmailBO> emailBOList) {
//    logger.info("[发送邮件事件发布],请求参数:{}", emailBOList);
//    EmailApplicationEvent event = new EmailApplicationEvent(emailBOList);
//    applicationEventPublisher.publishEvent(event);
//  }
//
//
//}
