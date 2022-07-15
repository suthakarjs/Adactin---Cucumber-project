package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description Describes the Adactin Select Hotel page's performance with different scenarios,
 * 				   This class also consists the required WebElements of Select page.
 * @date 08-July-2022  
 *
 */

public class SelectHotelPage extends BaseClass{

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "login_title")
	private WebElement textSelectHotel;
	
	@FindBy (xpath = "//input[@id='radiobutton_0']")
	private WebElement btnRadio;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement btnContinue;
	
	@FindBy (id = "radiobutton_span")
	private WebElement textErrorWithoutSelectHotel;
	
	public WebElement getTextSelectHotel() {
		return textSelectHotel;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	

	public WebElement getTextErrorWithoutSelectHotel() {
		return textErrorWithoutSelectHotel;
	}
	
/**
 * @description Method of Select Hotel by choosing any of hotel and click Continue
 * @date 08-July-2022
 */
public void selectHotel() {
	toClick(getBtnRadio());
	toClick(getBtnContinue());
}	
	
/**
 * @description Method of Select Hotel by just clicks the Continue button alone
 * @date 08-July-2022
 */
public void withoutSelectHotel() {
	toClick(getBtnContinue());
}
	
	
	
}
