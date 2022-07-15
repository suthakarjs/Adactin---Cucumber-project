package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author Suthakar JS
 * @description Describes the actions which needs to execute before starting one scenario and the 
 * actions which needs to execute after the ends of that same scenario
 * @date 08-July-2022 
 *
 */
public class HooksClass extends BaseClass{
	static int i = 1;
@Before
  public void beforeScenario() throws IOException {
	System.out.println("Before Scenario" + " -> " + i);
	browserChoice(getPropertyFiles("browserType"));
	loadUrl(getPropertyFiles("url"));
	maximize();
	implicitWait(15);	
  }
	
@After
  public void afterScenario(Scenario scenario) {
	System.out.println("After Scenario" + " -> " + i+"\n");
	i++;
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
	scenario.embed(screenshotAs, "All Scenarios Screenshots");
	
	closeAllWindows();	
  }
		
}
