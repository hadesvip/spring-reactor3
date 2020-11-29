//package com.kevin.spring.application.event.sample.application.listener;
//
//import com.kevin.spring.application.event.sample.application.event.EmailApplicationEvent;
//import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
//import java.util.List;
//import org.hibernate.validator.constraints.Email;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Component;
//
///**
// * 事件监听
// *
// * @author wangyong
// */
//@EnableAsync
//@Component
//public class AsynEmailPubListener implements ApplicationListener<EmailApplicationEvent> {
//
//  private static final Logger logger = LoggerFactory.getLogger(AsynEmailPubListener.class);
//
//
//  @Override
//  public void onApplicationEvent(EmailApplicationEvent event) {
//    logger.info("邮件异步事件监听，事件入参:{}", event.getSource());
//    Object source = event.getSource();
//    sendEmail((List<EmailBO>) source);
//    logger.info("邮件异步事件处理成功");
//  }
//
//
//  private void sendEmail(List<EmailBO> emailBOList) {
//    logger.info("发送邮件...");
//    for (EmailBO emailBO : emailBOList) {
//      logger.info("发货邮件参数:{}", emailBO);
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
//    logger.info("发送邮件结束");
//  }
//}
