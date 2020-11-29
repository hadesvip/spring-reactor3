package com.kevin.spring.application.event.sample.service;

import com.kevin.spring.application.event.sample.domain.bo.UserBO;
import com.kevin.spring.application.event.sample.domain.dto.UserDTO;
import com.kevin.spring.application.event.sample.domain.po.UserPO;

/**
 * 用户服务
 *
 * @author wangyong
 */
public interface UserService {

  UserBO register(UserDTO userDTO);


}
