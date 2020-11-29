package com.kevin.domain.po;

/**
 * 用户
 * @author wangyong
 */
public class UserPO {

  private String userId;

  private Integer age;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    String sb = "User{" + "userId='" + userId + '\''
        + ", age=" + age
        + '}';
    return sb;
  }
}
