package com.kevin.spring.application.event.sample.service.impl;

import com.kevin.spring.application.event.sample.application.handler.EmailEventHandler;
import com.kevin.spring.application.event.sample.domain.bo.EmailBO;
import com.kevin.spring.application.event.sample.domain.bo.UserBO;
import com.kevin.spring.application.event.sample.domain.dto.UserDTO;
import com.kevin.spring.application.event.sample.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Resource
  private EmailEventHandler emailEventHandler;


  @Override
  public UserBO register(UserDTO userDTO) {
    Assert.notNull(userDTO, "用户信息不可以为空");
    Function<UserDTO, UserBO> userBOConvert = dto -> {
      UserBO userBO = new UserBO();
      BeanUtils.copyProperties(dto, userBO);
      return userBO;
    };
    logger.info("发送邮件事件");
    List<EmailBO> emailBOList =
        Arrays.asList(new EmailBO("用户注册成功",
            "恭喜你账号注册成功", Arrays.asList(userDTO.getEmail())));
    emailEventHandler.publishEvent(emailBOList);
    return userBOConvert.apply(userDTO);
  }
}
