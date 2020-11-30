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

   ```java
    @Resource
     private ApplicationEventPublisher applicationEventPublisher;
   
   
     /**
      * 发布事件
      */
     public void publishEvent(List<EmailBO> emailBOList) {
       logger.info("[发送邮件事件发布],请求参数:{}", emailBOList);
       EmailApplicationEvent event = new EmailApplicationEvent(emailBOList);
       applicationEventPublisher.publishEvent(event);
     }
   ```

   

3. 定义事件监听 

   * 有序

     ```java
     @Component
     public class Order1PlanAllocatePubListener implements SmartApplicationListener {
     
         private static final Logger LOG = LoggerFactory.getLogger(Order1PlanAllocatePubListener.class);
     
         /**
          * supportsEventType用于指定支持的事件类型，只有支持的才调用onApplicationEvent
          * @param eventType
          * @return
          */
         @Override
         public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
             return eventType == PlanAllocatePubEvent.class;
         }
     
         /**
          * supportsSourceType支持的目标类型，只有支持的才调用onApplicationEvent
          * @param sourceType
          * @return
          */
         @Override
         public boolean supportsSourceType(Class<?> sourceType) {
             return sourceType == Long.class;
         }
     
         @Override
         public void onApplicationEvent(ApplicationEvent event) {
             LOG.info("[有序事件][事件监听][Order:1]数据创建, 编号:" + event.getSource());
             doSomething();
         }
     
         /**
          * 优先级顺序，越小优先级越高
          * @return
          */
         @Override
         public int getOrder() {
             return 1;
         }
     
         public void doSomething(){
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 LOG.error(e.getLocalizedMessage(), e);
             }
         }
     }
     
     ```

     ```java
     @Component
     public class Order2PlanAllocatePubListener implements SmartApplicationListener{
     
         private static final Logger LOG =  LoggerFactory.getLogger(Order2PlanAllocatePubListener.class);
     
         /**
          * supportsEventType用于指定支持的事件类型，只有支持的才调用onApplicationEvent
          * @param eventType
          * @return
          */
         @Override
         public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
             return eventType == PlanAllocatePubEvent.class;
         }
     
         /**
          * supportsSourceType支持的目标类型，只有支持的才调用onApplicationEvent
          * @param sourceType
          * @return
          */
         @Override
         public boolean supportsSourceType(Class<?> sourceType) {
             return sourceType == Long.class;
         }
     
         @Override
         public void onApplicationEvent(ApplicationEvent event) {
             LOG.info("[有序事件][事件监听][Order:2]数据创建, 编号:" + event.getSource());
             doSomething();
         }
     
         /**
          * 优先级顺序，越小优先级越高
          * @return
          */
         @Override
         public int getOrder() {
             return 2;
         }
     
         public void doSomething(){
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 LOG.error(e.getLocalizedMessage(), e);
             }
         }
     }
     
     ```

     

   * 无序

     * 同步

       ```java
       @Component
       public class SyncPlanAllocatePubListener implements ApplicationListener<PlanAllocatePubEvent>{
       
           private static final Logger LOG = LoggerFactory.getLogger(SyncPlanAllocatePubListener.class);
       
           @Override
           public void onApplicationEvent(PlanAllocatePubEvent planAllocatePubEvent) {
               LOG.info("[同步][事件监听][开始]数据创建, 数据编号:" + planAllocatePubEvent.getSource());
               doSomething();
               LOG.info("[同步][事件监听][结束]数据创建, 数据编号:" + planAllocatePubEvent.getSource());
           }
       
           public void doSomething(){
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   LOG.error(e.getLocalizedMessage(), e);
               }
           }
       
       }
       ```

       

     * 异步

       ```java
       @Component
       @EnableAsync
       public class AsynPlanAllocatePubListener implements ApplicationListener<PlanAllocatePubEvent> {
       
           private static final Logger LOG = LoggerFactory.getLogger(AsynPlanAllocatePubListener.class);
       
           @Async
           @Override
           public void onApplicationEvent(PlanAllocatePubEvent planAllocatePubEvent) {
               LOG.info("[异步][事件监听][开始]数据创建, 数据编号:" + planAllocatePubEvent.getSource());
               doSomething();
               LOG.info("[异步][事件监听][结束]数据创建, 数据编号:" + planAllocatePubEvent.getSource());
           }
       
           public void doSomething(){
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   LOG.error(e.getLocalizedMessage(), e);
               }
           }
       
       }
       ```

       官网文档（7.15.2 Standard and custom events）

       https://docs.spring.io/spring-framework/docs/4.3.29.RELEASE/spring-framework-reference/htmlsingle/


