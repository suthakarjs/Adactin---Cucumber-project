package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description -> Describes the Adactin Book Hotel page's performance with different scenarios,
 * 				   This class also consists the required WebElements of Book page.
 * @date -> 08-July-2022  
 *
 */

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//td[text()='Book A Hotel ']")
	private WebElement textBookHotel;
	
	@FindBy (xpath = "//input[@id='first_name']")
	private WebElement txtFirstName;
	
	@FindBy (xpath = "//input[@id='last_name']")
	private WebElement txtLastName;
	
	@FindBy (xpath = "//textarea[@id='address']")
	private WebElement txtAddress;
	
	@FindBy (xpath = "//input[@id='cc_num']")
	private WebElement txtCardNo;
	
	@FindBy (xpath = "//select[@id='cc_type']")
	private WebElement dDnCardType;
	
	@FindBy (xpath = "//select[@id='cc_exp_month']")
	private WebElement dDnExpMonth;
	
	@FindBy (xpath = "//select[@id='cc_exp_year']")
	private WebElement dDnExpYear;
	
	@FindBy (xpath = "//input[@id='cc_cvv']")
	private WebElement txtCvvNum;
	
	@FindBy (xpath = "//input[@id='book_now']")
	private WebElement btnBookNow;
	
	@FindBy (id = "first_name_span")
	private WebElement textFirstNameSpan;
	
	@FindBy (id = "last_name_span")
	private WebElement textLastNameSpan;
	
	@FindBy (id = "address_span")
	private WebElement textAddressSpan;
	
	@FindBy (id = "cc_num_span")
	private WebElement textCardNumSpan;
	
	@FindBy (id = "cc_type_span")
	private WebElement textCardTypeSpan;
	
	@FindBy (id = "cc_expiry_span")
	private WebElement textExpirySpan;
	
	@FindBy (id = "cc_cvv_span")
	private WebElement textCVVSpan;
	
	public WebElement getTextBookHotel() {
		return textBookHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getdDnCardType() {
		return dDnCardType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvvNum() {
		return txtCvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
	public WebElement getTextFirstNameSpan() {
		return textFirstNameSpan;
	}

	public WebElement getTextLastNameSpan() {
		return textLastNameSpan;
	}

	public WebElement getTextAddressSpan() {
		return textAddressSpan;
	}

	public WebElement getTextCardNumSpan() {
		return textCardNumSpan;
	}

	public WebElement getTextCardTypeSpan() {
		return textCardTypeSpan;
	}

	public WebElement getTextExpirySpan() {
		return textExpirySpan;
	}

	public WebElement getTextCVVSpan() {
		return textCVVSpan;
	}

/**
 * 	
 * @param firstName
 * @param lastName
 * @param address
 * @param dataTable
 * @description -> Method of Book Hotel by providing datas to all the fields
 * @date -> 08-July-2022
 */
public void bookHotel(String firstName,String lastName,String address,io.cucumber.datatable.DataTable dataTable) {
	
	sendKeys(getTxtFirstName(),firstName);
	sendKeys(getTxtLastName(), lastName);
	sendKeys(getTxtAddress(), address);
	
	List<Map<String, String>> list = dataTable.asMaps();
	
	Map<String, String> map = list.get(2);
	  String cardNum = map.get("cardNumber");
	  String cardType = map.get("cardType");
	  String expiryMonth = map.get("expMonth");
	  String expiryYear = map.get("expYear");
	  String cvvNumber = map.get("cvvNumber");

	sendKeys(getTxtCardNo(), cardNum);
	sendKeys(getdDnCardType(), cardType);
	sendKeys(getdDnExpMonth(), expiryMonth);
	sendKeys(getdDnExpYear(), expiryYear);
	sendKeys(getTxtCvvNum(), cvvNumber);
	
	toClick(getBtnBookNow());	
}
	
/**
 * @description -> Method of Book Hotel by just clicks the BookNow button alone
 * @date -> 08-July-2022
 */
public void bookHotel() {

	toClick(getBtnBookNow());
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
