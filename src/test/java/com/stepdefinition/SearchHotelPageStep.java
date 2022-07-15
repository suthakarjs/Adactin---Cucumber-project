package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suthakar JS
 * @description Describes the different steps of Hotel Search process and 
 * also it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class SearchHotelPageStep {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should perform Search by providing all the fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void searchByAllTheFields(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsCount, String childsCount) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsCount, childsCount);
	}

	@Then("User should verify after search {string}")
	public void verifyMessageAfterSearch(String expectedSearchVerifyMessage) {
		Assert.assertEquals("Searched Verification - After Search Hotel", expectedSearchVerifyMessage, pom.getSelectHotelPage().getTextSelectHotel().getText());
	}

	@Then("User should perform Search by entering all the mandatory fields only {string},{string},{string},{string} and {string}")
	public void searchByMandatoryFields(String location, String noOfRooms, String checkInDate, String checkOutDate, String adultsCount) {
		pom.getSearchHotelPage().searchHotel(location, noOfRooms, checkInDate, checkOutDate, adultsCount);
	}

	@Then("User should perform Search by providing the check-out-date before than check-in-date {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void searchByCheckOutDateBeforeThanCheckInDate(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsCount, String childsCount) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsCount, childsCount);
	}

	@Then("User should verify after Search these Error messages {string},{string}")
	public void verifyErrorMessagesDuetoDate(String expectedErrorByDate1, String expectedErrorByDate2) {
		Assert.assertEquals("Error Verification - Wrong Check-In-Date", expectedErrorByDate1, pom.getSearchHotelPage().getTextErrorCheckInSpan().getText());
		Assert.assertEquals("Error Verification - Wrong Check-Out-Date", expectedErrorByDate2, pom.getSearchHotelPage().getTextErrorCheckOutSpan().getText());
	}

	@Then("User should verify an Error message after Search hotel {string}")
	public void verifyErrorMessageByWithoutEnteringFields(String expectedErrorByWithoutFields) {
		pom.getSearchHotelPage().searchHotel();
		Assert.assertEquals("Error Verification - Empty Location", expectedErrorByWithoutFields, pom.getSearchHotelPage().getTextErrorLocationSpan().getText());
	}

	
	
	
	
	
	
	
	
	
	
}
