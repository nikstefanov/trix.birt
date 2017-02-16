package com.trix.birt.share.dto;

import java.io.Serializable;

public class LabelContentDto implements Serializable {
  private static final long serialVersionUID = 9083763733041433054L;
  private String labelText;
  private String labelKey;
  private String helpText;
  private String helpKey;
  
  public String getLabelText() {
    return labelText;
  }
  public void setLabelText(String labelText) {
    this.labelText = labelText;
  }
  public String getLabelKey() {
    return labelKey;
  }
  public void setLabelKey(String labelKey) {
    this.labelKey = labelKey;
  }
  public String getHelpText() {
    return helpText;
  }
  public void setHelpText(String helpText) {
    this.helpText = helpText;
  }
  public String getHelpKey() {
    return helpKey;
  }
  public void setHelpKey(String helpKey) {
    this.helpKey = helpKey;
  }
  
  
}
