package com.trix.birt.share.dto;

import java.io.Serializable;

public class BandContentDto implements Serializable {
  
  private static final long serialVersionUID = -647219351426191662L;
  public static final int BAND_DETAIL = 0;
  public static final int BAND_HEADER = 1;
  public static final int BAND_FOOTER = 2;
  public static final int GROUP_HEADER = 3;
  public static final int GROUP_FOOTER = 4;
  
  private String groupId;
  private int bandType;
  
  public BandContentDto(String groupId, int bandType) {
    this.groupId = groupId;
    this.bandType = bandType;
  }
  public BandContentDto() {
    
  }
  public String getGroupId() {
    return groupId;
  }
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
  public int getBandType() {
    return bandType;
  }
  public void setBandType(int bandType) {
    this.bandType = bandType;
  }
  
}
