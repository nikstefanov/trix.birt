package com.trix.birt.share.dto;

import java.io.Serializable;

public class ColumnDto implements Serializable {
  private static final long serialVersionUID = 1170608766727442622L;
 
  private String name;
  private double width = -1.0;
  private String visibleFormat;
  private LabelContentDto title;  
  
  public ColumnDto() {
    
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ColumnDto(int i) {
    name = "c" + i;
  }
  
  public double getWidth() {
    return width;
  }
  public void setWidth(double width) {
    this.width = width;
  }
  public String getVisibleFormat() {
    return visibleFormat;
  }
  public void setVisibleFormat(String visibleFormat) {
    this.visibleFormat = visibleFormat;
  }
  public LabelContentDto getTitle() {
    return title;
  }
  public void setTitle(LabelContentDto title) {
    this.title = title;
  }  
}
