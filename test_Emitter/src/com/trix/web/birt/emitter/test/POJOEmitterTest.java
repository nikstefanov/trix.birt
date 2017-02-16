package com.trix.web.birt.emitter.test;

import java.util.logging.Level;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.RenderOption;

import com.trix.birt.share.dto.ReportContentDto;

public class POJOEmitterTest {
  
  private static String BIRT_HOME =
      "D:/Users/User/Development/Temp/birt-runtime-4_3_1/ReportEngine/";
  private static String TEMP_LOCATION =
      "D:/Users/User/Development/Temp/ReportHandler";
  private static String DESIGN_FILE =
      "C:/Users/User/Documents/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTable.rptdesign";
  private static String DOCUMNET_FILE =
      "C:/Users/User/Documents/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTable.rptdocument";
  private static String OUTPUT_FILE =
      "C:/Users/User/Documents/Development/Workspaces/trix.birt/"
          + "test_birt_report/SimpleTable.txt";
  private IReportEngine reportEngine;
  private String renderFormat;
  private ReportContentDto reportContentDto;
  
  private POJOEmitterTest(String format) throws Exception {
    final EngineConfig config = new EngineConfig( );
    config.setLogConfig(TEMP_LOCATION, Level.FINE);
    config.setBIRTHome(BIRT_HOME);
    
    Platform.startup( config );
    IReportEngineFactory factory =
        (IReportEngineFactory) Platform.createFactoryObject(
            IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
    reportEngine = factory.createReportEngine( config );
    reportEngine.changeLogLevel( Level.WARNING );
    
    renderFormat = format;
  }
  
  private void reportRun() throws Exception {
    //Open a report design 
    IReportRunnable design = reportEngine.openReportDesign(DESIGN_FILE);        
    //Create task to run the report - use the task to execute
    //the report and save to disk.
    IRunTask task = reportEngine.createRunTask(design); 
    //Set parent classloader for reportEngine
//    task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY,
//        POJOEmitterTest.class.getClassLoader());             
    //run the report and destroy the reportEngine
    task.run(DOCUMNET_FILE);
    task.close();
  }
  
  private void reportRender() throws Exception {
    //Open a report document 
    IReportDocument reportDocument =
        reportEngine.openReportDocument(DOCUMNET_FILE); 
    IRenderOption options = new RenderOption();   
    options.setOutputFormat(renderFormat);
    if (renderFormat.equals("POJO")){
      reportContentDto = new ReportContentDto();
      options.setOption("pojo", reportContentDto);
    }
//    options.setOutputFileName(OUTPUT_FILE);
    //Create Render Task
    IRenderTask task = reportEngine.createRenderTask(reportDocument);
    //Set parent classloader report reportEngine
//    task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY,
//        POJOEmitterTest.class.getClassLoader());   
    task.setRenderOption(options);
//    taskRend.setPageRange("1-2");
    task.render();
    task.close();
    reportDocument.close();
  }
  
  private void reportRunAndRender() throws Exception {
    IReportRunnable runnable = reportEngine.openReportDesign(DESIGN_FILE);
    IRenderOption options = new RenderOption();   
    options.setOutputFormat(renderFormat);
    options.setOutputFileName(OUTPUT_FILE);
    IRunAndRenderTask task = reportEngine.createRunAndRenderTask(runnable);    
    task.setRenderOption(options);
    task.run();
    task.close();
  }
  
  private void exit() {
    reportEngine.destroy();
    Platform.shutdown();  
  }

  public void printReportContentDto() {
    if (renderFormat.equals("POJO")){
      System.out.println("Title:"+reportContentDto.getTitle());
      System.out.println();
      
    }
  }
  
  public static void main(String[] args) {
    try{
      POJOEmitterTest test = new POJOEmitterTest("POJO");
//      test.reportRun();
      test.reportRender();
//      test.reportRunAndRender();
      test.exit();
      test.printReportContentDto();
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
