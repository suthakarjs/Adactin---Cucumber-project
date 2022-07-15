package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions (features = {"src\\test\\resources"},glue = {"com.stepdefinition"},monochrome = true,strict = false,
		plugin = {"json:target/finalreport.json"},snippets = SnippetType.CAMELCASE,dryRun = false)

/**
 * 
 * @author Suthakar JS
 * @description Class is helps to execute all our scripts and generate json report as well.
 * @date 08-July-2022
 */
public class TestRunnerClass extends BaseClass{
 
  @AfterClass
  
 /**
  * @description Method is to sends the generated json report to jvm report conversion process 
  * @throws IOException
  * @date 08-July-2022
  */
  public static void afterClass() throws IOException {
		
		Reporting report = new Reporting();
		report.adactinJVMReport(System.getProperty("user.dir")+getPropertyFiles("jsonReportPath"));														
  }
	
}
