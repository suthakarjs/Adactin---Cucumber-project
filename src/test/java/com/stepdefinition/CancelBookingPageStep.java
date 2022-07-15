package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;
import com.pages.BookingConfirmationPage;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suthakar JS
 * @description Describes the different steps of Cancel Booking process and 
 * also it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class CancelBookingPageStep {

	PageObjectManager pom = new PageObjectManager();
	BookingConfirmationPage bookingConfirmationPage = pom.getBookingConfirmationPage();
	
	@Then("User should perform cancel booking")
	public void cancelBooking() {
		String orderId = bookingConfirmationPage.getOrderId();
		pom.getCancelBookingPage().cancelBooking(orderId);
	}

	@Then("User should verify the message after cancel booking which contains {string}")
	public void verifyMessageAfterCancelBooking(String expectedMessageByCancel) {
Assert.assertEquals("Verification - Booking Cancelled", expectedMessageByCancel, pom.getCancelBookingPage().getTextCancelledHotel().getText().trim() );
	}

	@Then("User should perform cancel booking by using existing {string}")
	public void cancelBookingByExistingId(String orderId) {
		pom.getCancelBookingPage().cancelBooking(orderId);
	}
}
