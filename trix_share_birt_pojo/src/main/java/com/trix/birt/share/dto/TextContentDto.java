package com.trix.birt.share.dto;

import java.io.Serializable;

public class TextContentDto implements Serializable {  
  private static final long serialVersionUID = 1732111087560414779L;
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
  
}
