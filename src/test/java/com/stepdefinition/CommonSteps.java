package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suthakar JS
 * @description Describes the Common steps of Adactin Hotel and it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class CommonSteps  {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login {string}")
	public void userShouldVerifyAfterLogin(String expectedLoginMessage) {
		
	String helloText = pom.getSearchHotelPage().getTextHelloMsg().getAttribute("value");
	Assert.assertEquals("Successful Verificaton - After a Valid Login", expectedLoginMessage, helloText);
}
	
	
	
	
}
