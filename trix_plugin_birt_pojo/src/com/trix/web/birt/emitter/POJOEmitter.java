package com.trix.web.birt.emitter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.engine.content.IAutoTextContent;
import org.eclipse.birt.report.engine.content.ICellContent;
import org.eclipse.birt.report.engine.content.IContainerContent;
import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IDataContent;
import org.eclipse.birt.report.engine.content.IForeignContent;
import org.eclipse.birt.report.engine.content.IGroupContent;
import org.eclipse.birt.report.engine.content.IImageContent;
import org.eclipse.birt.report.engine.content.ILabelContent;
import org.eclipse.birt.report.engine.content.IListBandContent;
import org.eclipse.birt.report.engine.content.IListContent;
import org.eclipse.birt.report.engine.content.IListGroupContent;
import org.eclipse.birt.report.engine.content.IPageContent;
import org.eclipse.birt.report.engine.content.IReportContent;
import org.eclipse.birt.report.engine.content.IRowContent;
import org.eclipse.birt.report.engine.content.ITableBandContent;
import org.eclipse.birt.report.engine.content.ITableContent;
import org.eclipse.birt.report.engine.content.ITableGroupContent;
import org.eclipse.birt.report.engine.content.ITextContent;
import org.eclipse.birt.report.engine.emitter.IContentEmitter;
import org.eclipse.birt.report.engine.emitter.IEmitterServices;
import org.json.JSONStringer;

import com.trix.report.dto.ReportDataDto;

public class POJOEmitter implements IContentEmitter {  
  private ReportDataDto reportDataDto; 
  private int cellIndex;  
  private StringBuilder cellString;
  private JSONStringer jsonStringer;
  private PrintStream logStream;
  
  public POJOEmitter() {
    reportDataDto = null;    
    cellString = new StringBuilder();
    jsonStringer = new JSONStringer();
    logStream = new PrintStream(new ByteArrayOutputStream());//System.out;
  }
  
  @Override
  public void end(IReportContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);    
    jsonStringer.endArray();
    reportDataDto.setDataJson(jsonStringer.toString());
  }

  @Override
  public void endCell(ICellContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);  
    jsonStringer.key("c"+cellIndex);
    jsonStringer.value(cellString);
    cellIndex++;
  }

  @Override
  public void endContainer(IContainerContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endContent(IContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endGroup(IGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endList(IListContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endListBand(IListBandContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endListGroup(IListGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);

  }

  @Override
  public void endPage(IPageContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);
  }

  @Override
  public void endRow(IRowContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);   
    jsonStringer.endObject();
  }

  @Override
  public void endTable(ITableContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);
    jsonStringer.endArray().endObject();
  }

  @Override
  public void endTableBand(ITableBandContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);
  }

  @Override
  public void endTableGroup(ITableGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-end";
    logStream.println(message);
  }  
  
  @Override
  public String getOutputFormat() {    
    return "POJO";
  }

  @Override
  public void initialize(IEmitterServices arg0) throws BirtException {
    String message = arg0.getClass().getName();
    logStream.println(message);
    reportDataDto = (ReportDataDto) arg0.getRenderOption().getOption("pojo");
  }

  @Override
  public void start(IReportContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
    jsonStringer.array();
  }

  @Override
  public void startAutoText(IAutoTextContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
  }

  @Override
  public void startCell(ICellContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
    // empty cellString content
    if (cellString.length() > 0) cellString.delete(0, cellString.length());
  }

  @Override
  public void startContainer(IContainerContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startContent(IContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startData(IDataContent dataContent) throws BirtException {
    String message = dataContent.getClass().getName() + "-begin";
    logStream.println(message);    
    // dividing from other labels or data
    if (cellString.length() > 0) {        
      cellString.append(' ');
    }
    if (null != dataContent.getValue()) {
      cellString.append(dataContent.getValue().toString());
    }
  }

  @Override
  public void startForeign(IForeignContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startGroup(IGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startImage(IImageContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startLabel(ILabelContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);    
    //dividing from other labels or data  
    if (cellString.length()>0) {      
      cellString.append(' ');
    }
    cellString.append(arg0.getLabelText());    
  }

  @Override
  public void startList(IListContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startListBand(IListBandContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
    
  }

  @Override
  public void startListGroup(IListGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startPage(IPageContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
  }

  @Override
  public void startRow(IRowContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message); 
    cellIndex = 0;    
    jsonStringer.object();
  }

  @Override
  public void startTable(ITableContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);
//    System.out.println("Table instanceId:" + arg0.getInstanceID().toString());
//    System.out.println("Table Name:" + arg0.getName());
    jsonStringer.object();
    jsonStringer.key("name");
    jsonStringer.value(arg0.getName());
    jsonStringer.key("data");
      jsonStringer.array();
  }

  @Override
  public void startTableBand(ITableBandContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startTableGroup(ITableGroupContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }

  @Override
  public void startText(ITextContent arg0) throws BirtException {
    String message = arg0.getClass().getName()+"-begin";
    logStream.println(message);

  }
}
