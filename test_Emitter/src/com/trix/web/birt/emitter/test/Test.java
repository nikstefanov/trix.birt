package com.trix.web.birt.emitter.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.model.api.DataSetHandle;
import org.eclipse.birt.report.model.api.OdaDataSetHandle;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.StructureFactory;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.api.elements.DesignChoiceConstants;
import org.eclipse.birt.report.model.api.elements.structures.FilterCondition;

import com.trix.birt.share.dto.FilterItemDto;
import com.trix.birt.share.dto.ReportDto;

public class Test {  
 
  private static String TEMP_LOCATION =
      "D:/Users/User/Development/Temp/ReportHandler";
  private static String DESIGN_FILE =
      "D:/Users/User/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTableMySQL.rptdesign";
  private static String DOCUMNET_FILE =
      "D:/Users/User/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTable.rptdocument";
  private static String OUTPUT_FILE =
      "D:/Users/User/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTable.html";
  private static Map<Integer,String> paramDataTypeMap;
  private IReportEngine reportEngine;
  private IRenderOption renderOptions;
  
  static{
    paramDataTypeMap = new HashMap<Integer,String>(9);
    paramDataTypeMap.put(IParameterDefn.TYPE_ANY, "Any");
    paramDataTypeMap.put(IParameterDefn.TYPE_STRING, "String");
    paramDataTypeMap.put(IParameterDefn.TYPE_FLOAT, "Float");
    paramDataTypeMap.put(IParameterDefn.TYPE_DECIMAL, "Decimal");
    paramDataTypeMap.put(IParameterDefn.TYPE_DATE_TIME, "Date Time");    
    paramDataTypeMap.put(IParameterDefn.TYPE_BOOLEAN, "Boolean");
    paramDataTypeMap.put(IParameterDefn.TYPE_INTEGER, "Integer");
    paramDataTypeMap.put(IParameterDefn.TYPE_DATE, "Date");
    paramDataTypeMap.put(IParameterDefn.TYPE_TIME, "Time");    
  }
  
  public Test() throws BirtException {
    init();
    renderOptions = new RenderOption();    
  }
  
  public void init() throws BirtException {
    final EngineConfig config = new EngineConfig( );
    config.setLogConfig(TEMP_LOCATION, Level.OFF);    
    Platform.startup( config );
    IReportEngineFactory factory =
        (IReportEngineFactory) Platform.createFactoryObject(
            IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
    reportEngine = factory.createReportEngine( config );
  }
  
  public void reportRun() throws Exception {    
    IReportRunnable design = reportEngine.openReportDesign(DESIGN_FILE);    
    IRunTask task = reportEngine.createRunTask(design);
    task.run(DOCUMNET_FILE);
    task.close();
  }
  
  public void reportRender() throws Exception {    
    IReportDocument reportDocument =
        reportEngine.openReportDocument(DOCUMNET_FILE);
    IRenderTask task = reportEngine.createRenderTask(reportDocument);   
    task.setRenderOption(renderOptions);
    task.render();
    task.close();
    reportDocument.close();
  }
  
  public void reportRunAndRender() throws Exception {
    IReportRunnable runnable = reportEngine.openReportDesign(DESIGN_FILE);
    IRunAndRenderTask task = reportEngine.createRunAndRenderTask(runnable);    
    task.setRenderOption(renderOptions);
    task.run();
    task.close();
  }
  
  public void setRenderOption(String key, Object value) {
    renderOptions.setOption(key, value);
  }
  
  public void exit() {
    reportEngine.destroy();
    Platform.shutdown();  
  }

  public void printReportDto(ReportDto reportDto) {    
    System.out.println("Title:"+reportDto.getTitle());
    System.out.println();
  }
  
  public void runPojoEmitterTest() throws Exception {
    ReportDto report = new ReportDto();
    renderOptions.setOutputFormat("POJO");
    renderOptions.setOption("pojo", report);
    reportRun();
    reportRender();
    printReportDto(report);    
  }
  
  public void runHtmlEmitter() throws Exception{
    renderOptions.setOutputFormat("HTML");
    renderOptions.setOutputFileName(OUTPUT_FILE);
    reportRun();
    reportRender();
  }
  
  public void addFilterCondition(ReportDesignHandle designHandle)
      throws SemanticException {
    DataSetHandle dataSetHandle =
        (DataSetHandle)designHandle.getDataSets().get(0);
    FilterCondition filterCondition = StructureFactory.createFilterCond();
    filterCondition.setExpr(
        "row['officeCode']=='1'||row['officeCode']=='2'||row['city']=='Paris'"); 
    filterCondition.setOperator(DesignChoiceConstants.FILTER_OPERATOR_TRUE);
//    filterCondition.setValue1("4");
    dataSetHandle.addFilter(filterCondition);
//    designHandle.saveAs( "c:/temp/sample.rptdesign" ); //$NON-NLS-1$
  }
  
  public void addFilterRunAndRender()
      throws EngineException, SemanticException {
    renderOptions.setOutputFormat("HTML");
    renderOptions.setOutputFileName(OUTPUT_FILE);
    IReportRunnable design = reportEngine.openReportDesign(DESIGN_FILE);     
    addFilterCondition( (ReportDesignHandle) design.getDesignHandle( ) );
    IRunAndRenderTask task = reportEngine.createRunAndRenderTask(design);    
    task.setRenderOption(renderOptions);
    task.run();
    task.close();  
  }
  
  public void changeQueryText(ReportDesignHandle designHandle)
      throws SemanticException {
    OdaDataSetHandle odaDataSetHandle =
        (OdaDataSetHandle)designHandle.getDataSets().get(1);
    String query = odaDataSetHandle.getQueryText();    
    query = query.concat(" WHERE officeCode=1 OR officeCode=2 OR city='Paris'");
    odaDataSetHandle.setQueryText(query);
  }
  
  public void changeQueryRunAndRender()
      throws EngineException, SemanticException {
    renderOptions.setOutputFormat("HTML");
    renderOptions.setOutputFileName(OUTPUT_FILE);
    IReportRunnable design = reportEngine.openReportDesign(DESIGN_FILE);     
    changeQueryText( (ReportDesignHandle) design.getDesignHandle( ) );
    IRunAndRenderTask task = reportEngine.createRunAndRenderTask(design);    
    task.setRenderOption(renderOptions);
    task.run();
    task.close();  
  }
  
  public void getAllFilterProperties(ReportDesignHandle designHandle,
      ReportDto report) throws SemanticException {
//    for (Object object:designHandle.getAllParameters()) {
//      ScalarParameterHandle param = (ScalarParameterHandle) object;
     
//    }
  }  
  
  @SuppressWarnings("rawtypes")
  public void extractParameterProperties(Collection collection,
      ReportDto report) {    
    Iterator iter = collection.iterator( );
    FilterItemDto filterItemDto;
    while ( iter.hasNext( ) )
    {
      IScalarParameterDefn param = (IScalarParameterDefn) iter.next( );     
      if (param.getUserPropertyValue("IsFilter").equals("true")) {
        filterItemDto = new FilterItemDto();
        filterItemDto.setColumnName(param.getUserPropertyValue("ColumnName"));
        filterItemDto.setTrixId(param.getUserPropertyValue("TrixId"));
        filterItemDto.setName(param.getName());
        filterItemDto.setTitle(param.getPromptText());
        filterItemDto.setType(paramDataTypeMap.get(param.getDataType()));
        report.addFilterItem(filterItemDto);
      }
    }
  }
  
  public void pojoGetParametersRunAndRender() throws EngineException {
    ReportDto report = new ReportDto();
    renderOptions.setOutputFormat("POJO");
    renderOptions.setOption("pojo", report);    
    IReportRunnable design = reportEngine.openReportDesign(DESIGN_FILE);
    IGetParameterDefinitionTask taskPr =
        reportEngine.createGetParameterDefinitionTask( design );   
    extractParameterProperties(taskPr.getParameterDefns( false ), report);
    IRunAndRenderTask task = reportEngine.createRunAndRenderTask(design);    
    task.setRenderOption(renderOptions);
    task.run();
    task.close();
  }
  
  public static void main(String[] args) {
    try{
      Test test = new Test();
      test.runPojoEmitterTest();
//      test.runHtmlEmitter();
//      test.addFilterRunAndRender();
//      test.changeQueryRunAndRender();
//      test.pojoGetParametersRunAndRender();
      test.exit();     
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
