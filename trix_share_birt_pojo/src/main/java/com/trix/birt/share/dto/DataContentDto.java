package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.Date;

public class DataContentDto implements Serializable {  
  private static final long serialVersionUID = 959711404179628374L;
  public enum Type{STRING,INTEGER,LONG,DOUBLE,BOOLEAN,DATE}
  private Type type;
  private String stringValue;
  private Integer integerValue;
  private Long longValue;
  private Double doubleValue;
  private Boolean booleanValue;
  private Date dateValue;
  
  public Type getType() {
    return type;
  }
  public void setType(Type type) {
    this.type = type;
  }
  public String getStringValue() {
    return stringValue;
  }
  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }
  public Integer getIntegerValue() {
    return integerValue;
  }
  public void setIntegerValue(Integer integerValue) {
    this.integerValue = integerValue;
  }
  public Long getLongValue() {
    return longValue;
  }
  public void setLongValue(Long longValue) {
    this.longValue = longValue;
  }
  public Double getDoubleValue() {
    return doubleValue;
  }
  public void setDoubleValue(Double doubleValue) {
    this.doubleValue = doubleValue;
  }
  public Boolean getBooleanValue() {
    return booleanValue;
  }
  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }
  public Date getDateValue() {
    return dateValue;
  }
  public void setDateValue(Date dateValue) {
    this.dateValue = dateValue;
  }
  
  
}
