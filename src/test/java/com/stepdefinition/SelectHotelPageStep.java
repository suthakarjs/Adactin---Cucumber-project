package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suthakar JS
 * @description Describes the different steps of Select Hotel process and 
 * also it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class SelectHotelPageStep {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should perform Select hotel by choosing any of the hotel")
	public void selectHotelByChoosingAnyHotel() {
		pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify after Select hotel {string}")
	public void verifyAfterSelectHotel(String expectedSelectVerifyMessage) {
		Assert.assertEquals("Verification - After Select Hotel", expectedSelectVerifyMessage, pom.getBookHotelPage().getTextBookHotel().getText());
	}

	@Then("User should perform Select hotel by without choosing any of the hotel")
	public void selectHotelByWithoutChoosingHotel() {
		pom.getSelectHotelPage().withoutSelectHotel();
	}

	@Then("User should verify an Error message after Select hotel {string}")
	public void verifyErrorAfterSelectHotel(String expectedErrorByWithoutSelect) {
		Assert.assertEquals("Error Verification - Without Select Hotel", expectedErrorByWithoutSelect,  pom.getSelectHotelPage().getTextErrorWithoutSelectHotel().getText());
	}

	
	
	
	
	
	
}
