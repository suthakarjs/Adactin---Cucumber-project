package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description Describes the Adactin Hotel Cancel Booking function with different scenarios,
 * 				   This class also consists the required WebElements for cancel booking function.
 * @date 08-July-2022 
 *
 */
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "order_id_text")
	private WebElement txtSearchOrderId;
	
	@FindBy (id = "search_hotel_id")
	private WebElement btnSearch;

	@FindBy (xpath = "//input[contains(@id,'btn_id_')]")
	private WebElement btnCancel;
	
	@FindBy (id = "search_result_error")
	private WebElement textCancelledHotel;
	
public WebElement getTxtSearchOrderId() {
		return txtSearchOrderId;
	}

public WebElement getBtnSearch() {
		return btnSearch;
	}
	
public WebElement getBtnCancel() {
		return btnCancel;
	}

public WebElement getTextCancelledHotel() {
	return textCancelledHotel;
}

/**
 * 
 * @param orderId
 * @description Method of cancel booking by providing the Order-ID
 * @date 08-July-2022
 */
public void cancelBooking(String orderId) {
	
	toClick(BookingConfirmationPage.getBtnBookedItinerary());
	sendKeys(getTxtSearchOrderId(), orderId);
	toClick(getBtnSearch());
	toClick(getBtnCancel());
	clickOkInAlert();
}


	
	
	
	
	
	
}
