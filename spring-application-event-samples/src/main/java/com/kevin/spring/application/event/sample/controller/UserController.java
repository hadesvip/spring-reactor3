package com.kevin.spring.application.event.sample.controller;

import com.kevin.spring.application.event.sample.domain.bo.UserBO;
import com.kevin.spring.application.event.sample.domain.dto.UserDTO;
import com.kevin.spring.application.event.sample.domain.vo.UserVO;
import com.kevin.spring.application.event.sample.service.UserService;
import java.util.function.Function;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author wangyong
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);


  @Resource
  private UserService userService;

  @PostMapping("/register")
  public UserVO register(@RequestBody UserDTO userDTO) {
    logger.info("用户注册，请求参数:{}", userDTO);
    UserBO userBO = userService.register(userDTO);
    Function<UserBO, UserVO> convert = bo -> {
      UserVO vo = new UserVO();
      BeanUtils.copyProperties(bo, vo);
      return vo;
    };
    logger.info("注册用户，返回结果:{}", userBO);
    return convert.apply(userBO);

  }


}
