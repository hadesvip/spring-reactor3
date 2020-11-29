package com.kevin.domain.dto;

import java.util.Date;
import java.util.UUID;

public class BaseDTO<T> {

  public String id = UUID.randomUUID().toString().replace("-", "");

  public String createUserId;

  public String createUserName;

  public Date createDateTime;

  public String updateUserId;

  public String updateUserName;

  public Date updateDateTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public Date getCreateDateTime() {
    return createDateTime;
  }

  public void setCreateDateTime(Date createDateTime) {
    this.createDateTime = createDateTime;
  }

  public String getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(String updateUserId) {
    this.updateUserId = updateUserId;
  }

  public String getUpdateUserName() {
    return updateUserName;
  }

  public void setUpdateUserName(String updateUserName) {
    this.updateUserName = updateUserName;
  }

  public Date getUpdateDateTime() {
    return updateDateTime;
  }

  public void setUpdateDateTime(Date updateDateTime) {
    this.updateDateTime = updateDateTime;
  }
}
