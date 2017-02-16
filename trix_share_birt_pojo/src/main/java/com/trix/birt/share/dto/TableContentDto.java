package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class TableContentDto implements Serializable {
  private static final long serialVersionUID = -8598606227976741876L;
  private int columnCount;
  private String capiton;
  private String capitonKey;
  private boolean isHeaderRepeat;
  private TableBandContentDto header;
  private TableBandContentDto footer;
  private String summary;
  private ArrayList<RowContentDto> rowsList;
  private ArrayList<ColumnDto> columnsList;
  
  public int getColumnCount() {
    return columnCount;
  }
  public void setColumnCount(int columnCount) {
    this.columnCount = columnCount;
  }
  public String getCapiton() {
    return capiton;
  }
  public void setCapiton(String capiton) {
    this.capiton = capiton;
  }
  public String getCapitonKey() {
    return capitonKey;
  }
  public void setCapitonKey(String capitonKey) {
    this.capitonKey = capitonKey;
  }
  public boolean isHeaderRepeat() {
    return isHeaderRepeat;
  }
  public void setHeaderRepeat(boolean isHeaderRepeat) {
    this.isHeaderRepeat = isHeaderRepeat;
  }
  public TableBandContentDto getHeader() {
    return header;
  }
  public void setHeader(TableBandContentDto header) {
    this.header = header;
  }
  public TableBandContentDto getFooter() {
    return footer;
  }
  public void setFooter(TableBandContentDto footer) {
    this.footer = footer;
  }
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public ArrayList<RowContentDto> getRowsList() {
    return rowsList;
  }
  public void setRowsList(ArrayList<RowContentDto> rowsList) {
    this.rowsList = rowsList;
  }
  
  public void addRow(RowContentDto rowContentDto) {
    if (null == rowsList) {
      rowsList = new ArrayList<RowContentDto>();
    }
    rowsList.add(rowContentDto);
  }  
  public RowContentDto getRow(int i) {
    if (i<rowsList.size())
      return rowsList.get(i);
    else
      return null;
  }
  public ArrayList<ColumnDto> getColumnsList() {
    return columnsList;
  }
  public void setColumnsList(ArrayList<ColumnDto> columnsList) {
    this.columnsList = columnsList;
  }
  public void addColumn(ColumnDto columnDto) {
    if (null == columnsList) {
      columnsList = new ArrayList<ColumnDto>();
    }
    columnsList.add(columnDto);
  }  
  public ColumnDto getColumn(int i) {
    if (i<columnsList.size())
      return columnsList.get(i);
    else
      return null;
  }
}
