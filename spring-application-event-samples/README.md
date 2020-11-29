# 概述
## 实体类描述
  * dto
  
    数据传输对象  
  * po
  
    数据对象对应着数据库字段
  * vo
   
    对应页面数据

## spring驱动编程模型
### 创建方式
1. 定义ApplicationEvent

   * 继承ApplicationEvent 

     ```java
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
     
     ```

     

2. 使用applicationEventPulisher发布事件

3. 定义事件监听 


