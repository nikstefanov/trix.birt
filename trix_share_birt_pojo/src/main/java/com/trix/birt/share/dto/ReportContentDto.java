package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportContentDto implements Serializable {    
  private static final long serialVersionUID = 1671618847397118216L;
  
  private String title;  
  private List<ColumnDto> columns;
  private String jsonData;

  
  public void addColumn(ColumnDto column) {
    if (null == columns) {
      columns = new ArrayList<ColumnDto>();
    }
    columns.add(column);
  }
  
  public ColumnDto getColumn(int i) {
    if (null == columns) {
      columns = new ArrayList<ColumnDto>();
    }
    if (columns.size() <= i) {
      columns.set(i, new ColumnDto(i));
    }
    return columns.get(i);
  }
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<ColumnDto> getColumns() {
    return columns;
  }

  public void setColumns(List<ColumnDto> columns) {
    this.columns = columns;
  }

  public String getJsonData() {
    return jsonData;
  }

  public void setJsonData(String jsonData) {
    this.jsonData = jsonData;
  }
}
