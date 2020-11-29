package com.kevin.spring.application.event.sample.domain.bo;

import java.util.List;
import lombok.Data;

@Data
public class EmailBO {

  private String title;

  private String content;

  private List<String> reciverList;


  public EmailBO() {
  }

  public EmailBO(String title, String content, List<String> reciverList) {
    this.title = title;
    this.content = content;
    this.reciverList = reciverList;
  }
}
