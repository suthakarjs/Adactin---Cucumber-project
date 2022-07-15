package com.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Suthakar JS
 * @description Describes the report generation process after all the execution of test scripts
 * @date 08-July-2022
 */
public class Reporting extends BaseClass {
	
/**
 * 	
 * @param jsonFile
 * @throws IOException
 * @description Method is to generate the Cucumber report and stores it into the mentioned location
 * @date 08-July-2022 
 */
 public void adactinJVMReport(String jsonFile) throws IOException {
	  
	File file = new File(System.getProperty("user.dir")+getPropertyFiles("jvmReportPath"));
		
	Configuration configuration = new Configuration(file, "Adactin Hotel Booking - Automation");
	
	configuration.addClassifications("Browser", "Chrome Browser");
	configuration.addClassifications("OS", "Windows 10");
	configuration.addClassifications("Browser Version", "103.0.5060.66");
	
	List<String> jsonFiles = new ArrayList<String>(); 
	jsonFiles.add(jsonFile);
			
	ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);	
		
	builder.generateReports();	
		
 }
	
	
	
	
	
	
	
	
	

}
