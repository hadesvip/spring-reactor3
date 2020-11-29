package com.kevin.spring.application.event.sample.application.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 基础事件
 *
 * @author wangyong
 */
public class BaseApplicationEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public BaseApplicationEvent(T source) {
    super(source);
  }

  @Override
  public ResolvableType getResolvableType() {
    return ResolvableType.forClassWithGenerics(getClass(),
        ResolvableType.forInstance(getSource()));
  }
}
