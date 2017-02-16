package com.trix.birt.share.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RowContentDto implements Serializable {  
  private static final long serialVersionUID = -9001113969392524942L;
  
  private int rowId;
  private String groupId;
  private BandContentDto band;
  private List<CellContentDto> cellsList;
  
  public int getRowId() {
    return rowId;
  }
  public void setRowId(int rowId) {
    this.rowId = rowId;
  }
  public List<CellContentDto> getCellsList() {
    return cellsList;
  }
  public void setCellsList(List<CellContentDto> cellsList) {
    this.cellsList = cellsList;
  } 
  public void addCell(CellContentDto cellContentDto) {
    if (null == cellsList) {
      cellsList = new ArrayList<CellContentDto>();
    }
    cellsList.add(cellContentDto);
  }
  public CellContentDto getCell(int i) {
    if (i < cellsList.size())
      return cellsList.get(i);
    else
      return null;
  }
  public String getGroupId() {
    return groupId;
  }
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
  public BandContentDto getBand() {
    return band;
  }
  public void setBand(BandContentDto band) {
    this.band = band;
  }
}
