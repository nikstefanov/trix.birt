package com.trix.report.dto;

import java.io.Serializable;

public class ReportDataDto implements Serializable {  
  private static final long serialVersionUID = 6609025879624942235L;
  private String dataJson;
  
  public ReportDataDto() {
    dataJson = null;
  }
  
  public String getDataJson() {
    return dataJson;
  }
  public void setDataJson(String dataJson) {
    this.dataJson = dataJson;
  }

  
}
