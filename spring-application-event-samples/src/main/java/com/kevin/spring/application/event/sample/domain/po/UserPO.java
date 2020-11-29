package com.kevin.spring.application.event.sample.domain.po;

import lombok.Data;

/**
 * 用户信息
 *
 * @author wangyong
 */
@Data
public class UserPO {

  private String userId;

  private String userName;

  private String email;

  private String createDateTime;


}
