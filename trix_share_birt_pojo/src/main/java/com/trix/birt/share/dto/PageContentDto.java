package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PageContentDto implements Serializable {
  private static final long serialVersionUID = 588866899796423839L;

  private String orientation;
  private String pageType;
  private long pageNumber;
  private ArrayList<TableContentDto> tablesList;
  
  public String getOrientation() {
    return orientation;
  }
  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }
  public String getPageType() {
    return pageType;
  }
  public void setPageType(String pageType) {
    this.pageType = pageType;
  }
  public long getPageNumber() {
    return pageNumber;
  }
  public void setPageNumber(long pageNumber) {
    this.pageNumber = pageNumber;
  }  
  public void addTable(TableContentDto tableContentDto) {
    if (null == tablesList) {
      tablesList = new ArrayList<TableContentDto>();
    }
    tablesList.add(tableContentDto);
  }  
  public ArrayList<TableContentDto> getTablesList() {
    return tablesList;
  }
  
  public void setTablesList(ArrayList<TableContentDto> tablesList) {
    this.tablesList = tablesList;
  }  
  public TableContentDto getTable(int i) {
    if (i < tablesList.size())
      return tablesList.get(i);
    else
      return null;
  }
  
}
