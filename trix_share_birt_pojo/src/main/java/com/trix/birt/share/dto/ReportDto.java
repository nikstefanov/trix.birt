package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportDto implements Serializable {    
  private static final long serialVersionUID = 1671618847397118216L;
  
  private String title;  
  private List<ColumnDto> columns;
  private String jsonData;
  private List<FilterItemDto> filterItems;

  public void addFilterItem(FilterItemDto filter) {
    if (null == filterItems) {
      filterItems = new ArrayList<FilterItemDto>();
    }
    filterItems.add(filter);
  }
  
  public FilterItemDto getFilterItem(int i) {
    if (null != filterItems && filterItems.size() > i) {
      return filterItems.get(i);
    }    
    return null;
  }
  
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

  public List<FilterItemDto> getFilterItems() {
    return filterItems;
  }

  public void setFilterItems(List<FilterItemDto> filters) {
    this.filterItems = filters;
  }
}
