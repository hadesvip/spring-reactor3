package com.kevin.spring.application.event.sample.domain.dto;

import lombok.Data;

/**
 * 用户信息
 *
 * @author wangyong
 */
@Data
public class UserDTO {

  private String userId;

  private String userName;

  private String email;

  private String createDateTime;

}
