package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suthakar JS
 * @description Describes the different steps of Hotel Booking process and 
 * also it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class BookHotelPageStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User should perform Book hotel by entering {string},{string} and {string}")
	public void bookHotelByEnteringFields(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) throws IOException {
		pom.getBookHotelPage().bookHotel(getPropertyFiles("firstName"), getPropertyFiles("lastName"), getPropertyFiles("address"), dataTable);
	}

	@Then("User should verify the message after Book hotel {string}")
	public void verifyMessageAfterBookHotel(String expectedConfirmMessage) {
Assert.assertEquals("Verification - Hotel Booked", expectedConfirmMessage, pom.getBookingConfirmationPage().getTextBookingConfirmation().getText());
	}

	@Then("User should perform Book hotel by without entering the fields")
	public void bookHotelByWithoutEnteringFields() {
		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify these Error messages after Book hotel {string},{string},{string},{string},{string},{string} and {string}")
	public void verifyErrorAfterBookHotel(String expectedErrorByFirstName, String expectedErrorByLastName, String expectedErrorByAddress, String expectedErrorByCardNum, String expectedErrorByCardType, String expectedErrorByExpMonth, String expectedErrorByCVV) {		
Assert.assertEquals("Error Verification - Empty First Name", expectedErrorByFirstName, pom.getBookHotelPage().getTextFirstNameSpan().getText());
Assert.assertEquals("Error Verification - Empty Last Name", expectedErrorByLastName, pom.getBookHotelPage().getTextLastNameSpan().getText());
Assert.assertEquals("Error Verification - Empty Address", expectedErrorByAddress, pom.getBookHotelPage().getTextAddressSpan().getText());
Assert.assertEquals("Error Verification - Empty Card Number", expectedErrorByCardNum, pom.getBookHotelPage().getTextCardNumSpan().getText());
Assert.assertEquals("Error Verification - Empty Card Type", expectedErrorByCardType, pom.getBookHotelPage().getTextCardTypeSpan().getText());
Assert.assertEquals("Error Verification - Empty Expiry Date & month", expectedErrorByExpMonth, pom.getBookHotelPage().getTextExpirySpan().getText());
Assert.assertEquals("Error Verification - Empty CVV", expectedErrorByCVV, pom.getBookHotelPage().getTextCVVSpan().getText());
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
