package com.kevin.spring.application.event.sample.application.handler;

import com.kevin.spring.application.event.sample.application.event.BaseApplicationEvent;
import com.kevin.spring.application.event.sample.application.event.EmailApplicationEvent;
import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 *
 */
public class BaseEventHandler {

  private static final Logger logger = LoggerFactory.getLogger(BaseEventHandler.class);

  @EventListener
  @Async
  public void onApplicationEvent(BaseApplicationEvent<EmailBO> applicationEvent) {
    logger.info("邮件异步事件监听，事件入参:{}", applicationEvent);

    //dosomething


    logger.info("邮件异步事件处理成功");
  }

}
