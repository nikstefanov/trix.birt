package com.trix.birt.share.dto;

import java.io.Serializable;

public class FilterItemDto implements Serializable {
  private static final long serialVersionUID = -3534851883525543521L;
  
  private String columnName;
  private String name;
  private String title;
  private String trixId;
  private String type;
  
  public String getColumnName() {
    return columnName;
  }
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTrixId() {
    return trixId;
  }
  public void setTrixId(String trixId) {
    this.trixId = trixId;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
}
