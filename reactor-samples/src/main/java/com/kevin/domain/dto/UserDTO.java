package com.kevin.domain.dto;


public class UserDTO extends BaseDTO<UserDTO> {

  private Integer age;

  private String userName;

  private String email;

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    String sb = "UserDTO{" + "id='" + id + '\''
        + ", age=" + age
        + ", userName='" + userName + '\''
        + ", email='" + email + '\''
        + ", createUserId='" + createUserId + '\''
        + ", createUserName='" + createUserName + '\''
        + ", createDateTime=" + createDateTime
        + ", updateUserId='" + updateUserId + '\''
        + ", updateUserName='" + updateUserName + '\''
        + ", updateDateTime=" + updateDateTime
        + '}';
    return sb;
  }
}
