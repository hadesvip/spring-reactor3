package com.kevin.spring.application.event.sample.application.event;

import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
import java.util.List;
import org.springframework.context.ApplicationEvent;

/**
 * 发送邮件事件
 *
 * @author wangyong
 */
public class EmailApplicationEvent extends ApplicationEvent {

  public EmailApplicationEvent(List<EmailBO> emailBOList) {
    super(emailBOList);
  }
}
