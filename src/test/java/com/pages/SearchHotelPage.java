package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description -> Describes the Adactin Search Hotel page's performance with different scenarios,
 * 				   This class also consists the required webelements of Search page.
 * @date -> 08-July-2022  
 *
 */

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "username_show")
	private WebElement textHelloMsg;
	
	@FindBy (xpath ="//select[@id='location']")
	private WebElement dDnLocation;
	
	@FindBy (xpath = "//select[@name='hotels']")
	private WebElement dDnHotels;
	
	@FindBy (xpath = "//select[@id='room_type']")
	private WebElement dDnRoomType;
	
	@FindBy (xpath = "//select[@id='room_nos']")
	private WebElement dDnRooms;
	
	@FindBy (xpath = "//input[@id='datepick_in']")
	private WebElement dDnCheckIn;
	
	@FindBy (xpath = "//input[@id='datepick_out']")
	private WebElement dDnCheckOut;
	
	@FindBy (xpath = "//select[@id='adult_room']")
	private WebElement dDnAdults;
	
	@FindBy (xpath = "//select[@id='child_room']")
	private WebElement dDnChilds;
	
	@FindBy (xpath = "//input[@id='Submit']")
	private WebElement btnSearch;
	
	@FindBy (id = "checkin_span")
	private WebElement textErrorCheckInSpan;
	
	@FindBy (id = "checkout_span")
	private WebElement textErrorCheckOutSpan;
	
	@FindBy (id = "location_span")
	private WebElement textErrorLocationSpan;
	
	public WebElement getTextHelloMsg() {
		return textHelloMsg;
	}
	
	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRooms() {
		return dDnRooms;
	}

	public WebElement getdDnCheckIn() {
		return dDnCheckIn;
	}

	public WebElement getdDnCheckOut() {
		return dDnCheckOut;
	}

	public WebElement getdDnAdults() {
		return dDnAdults;
	}

	public WebElement getdDnChilds() {
		return dDnChilds;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public WebElement getTextErrorCheckInSpan() {
		return textErrorCheckInSpan;
	}

	public WebElement getTextErrorCheckOutSpan() {
		return textErrorCheckOutSpan;
	}

	public WebElement getTextErrorLocationSpan() {
		return textErrorLocationSpan;
	}
	
/**
 * 	
 * @param location
 * @param hotels
 * @param roomType
 * @param noOfRooms
 * @param checkInDate
 * @param checkOutDate
 * @param adultsCount
 * @param childsCount
 * @description -> Method of Search Hotel by providing datas to all the fields 
 * @date -> 08-July-2022
 */	
public void searchHotel(String location,String hotels,String roomType,String noOfRooms,String checkInDate,String checkOutDate,String adultsCount,String childsCount) {
		
	sendKeys(getdDnLocation(), location);	
	sendKeys(getdDnHotels(), hotels);
	sendKeys(getdDnRoomType(), roomType);
	sendKeys(getdDnRooms(), noOfRooms);
	getdDnCheckIn().clear();
	sendKeys(getdDnCheckIn(), checkInDate);	
	getdDnCheckOut().clear();
	sendKeys(getdDnCheckOut(), checkOutDate);
	sendKeys(getdDnAdults(), adultsCount);	
	sendKeys(getdDnChilds(), childsCount);	
		
	toClick(getBtnSearch());	
}

/**
 * 
 * @param location
 * @param noOfRooms
 * @param checkInDate
 * @param checkOutDate
 * @param adultsCount
 * @description -> Method of Search Hotel by providing datas to mandatory fields only 
 * @date -> 08-July-2022
 */
public void searchHotel(String location,String noOfRooms,String checkInDate,String checkOutDate,String adultsCount) {
	
	sendKeys(getdDnLocation(), location);	
	sendKeys(getdDnRooms(), noOfRooms);
	getdDnCheckIn().clear();
	sendKeys(getdDnCheckIn(), checkInDate);	
	getdDnCheckOut().clear();
	sendKeys(getdDnCheckOut(), checkOutDate);
	sendKeys(getdDnAdults(), adultsCount);
	
	toClick(getBtnSearch());	
}

/**
 * @description -> Method of Search Hotel by just clicks the Search button alone
 * @date -> 08-July-2022
 */
public void searchHotel() {

	toClick(getBtnSearch());
	
}
	
	
	
	
	
	
	
	
	
	
}
