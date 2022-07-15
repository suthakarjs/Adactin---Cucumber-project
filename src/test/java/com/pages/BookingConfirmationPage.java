package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description Describes the Adactin Hotel Booking Confirmation page's performance with different scenarios,
 * 				   This class also consists the required WebElements of Booking Confirmation page.
 * @date 08-July-2022  
 *
 */
public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name='order_no']")
	private static WebElement txtOrderNo;

	@FindBy (xpath = "//a[text()='Booked Itinerary']")
	private static WebElement btnBookedItinerary;
	
	@FindBy (xpath = "//td[text()='Booking Confirmation ']")
	private WebElement textBookingConfirmation;
	
	public static WebElement getBtnBookedItinerary() {
		return btnBookedItinerary;
	}
	
	public WebElement getTextBookingConfirmation() {
		return textBookingConfirmation;
	}

	public static WebElement getTxtOrderNo() {
		return txtOrderNo;
	}
	
/**
 * @description Method of getting the generated Order-ID after booked hotel
 * @date 08-July-2022
 * @return String
 */
public String getOrderId() {

	String orderNo = getByAttributeValue(getTxtOrderNo());
	return orderNo;
}	
	
	
	
	
	
	
}
