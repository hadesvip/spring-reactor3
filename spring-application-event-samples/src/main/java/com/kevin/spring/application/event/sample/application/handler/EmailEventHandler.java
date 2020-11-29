package com.kevin.spring.application.event.sample.application.handler;

import com.kevin.spring.application.event.sample.application.event.EmailApplicationEvent;
import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailEventHandler implements ApplicationEventPublisherAware {

  private static final Logger logger = LoggerFactory.getLogger(EmailEventHandler.class);

  /**
   * 事件发布者
   */
  private ApplicationEventPublisher applicationEventPublisher;


  /**
   * 发布事件
   */
  public void publishEvent(List<EmailBO> emailBOList) {
    logger.info("[发送邮件事件发布],请求参数:{}", emailBOList);
    EmailApplicationEvent event = new EmailApplicationEvent(emailBOList);
    applicationEventPublisher.publishEvent(event);
  }


  @EventListener
  @Async
  public void onApplicationEvent(EmailApplicationEvent event) {
    logger.info("邮件异步事件监听，事件入参:{}", event.getSource());
    Object source = event.getSource();
    sendEmail((List<EmailBO>) source);
    logger.info("邮件异步事件处理成功");
  }


  private void sendEmail(List<EmailBO> emailBOList) {
    logger.info("发送邮件...");
    for (EmailBO emailBO : emailBOList) {
      logger.info("发货邮件参数:{}", emailBO);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    logger.info("发送邮件结束");
  }


  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }
}
