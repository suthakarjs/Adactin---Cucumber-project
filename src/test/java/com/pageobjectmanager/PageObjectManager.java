package com.pageobjectmanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * 
 * @author Suthakar JS
 * @description Class which is helps to create only one object for the mentioned classes within
 * this.If already created then it'll restrict it.
 * @date 08-July-2022
 *
 */
public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage == null) ? bookingConfirmationPage = new BookingConfirmationPage() : bookingConfirmationPage;	
	}
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null) ? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
