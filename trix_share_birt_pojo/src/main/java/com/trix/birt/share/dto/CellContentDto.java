package com.trix.birt.share.dto;

import java.io.Serializable;


public class CellContentDto implements Serializable { 
  private static final long serialVersionUID = 8636371687286473018L;
  int colSpan;
  int rowSpan;
  int column;
  int row;
  
  private DataContentDto dataContentValue = null;
  private LabelContentDto labelContentValue = null;

  public int getColSpan() {
    return colSpan;
  }
  public void setColSpan(int colSpan) {
    this.colSpan = colSpan;
  }
  public int getRowSpan() {
    return rowSpan;
  }
  public void setRowSpan(int rowSpan) {
    this.rowSpan = rowSpan;
  }
  public int getColumn() {
    return column;
  }
  public void setColumn(int column) {
    this.column = column;
  }
  public int getRow() {
    return row;
  }
  public void setRow(int row) {
    this.row = row;
  }
  public DataContentDto getDataContentValue() {
    return dataContentValue;
  }
  public void setDataContentValue(DataContentDto dataContentValue) {
    this.dataContentValue = dataContentValue;
  }
  public LabelContentDto getLabelContentValue() {
    return labelContentValue;
  }
  public void setLabelContentValue(LabelContentDto labelContentValue) {
    this.labelContentValue = labelContentValue;
  }
}
