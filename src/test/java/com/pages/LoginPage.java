package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Suthakar JS
 * @description Describes the Adactin Hotel Login page's performance with different scenarios,
 * 				   This class also consists the required webelements of Login page.
 * @date 08-July-2022  
 *
 */


public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id = "username")
	private WebElement txtUserName;
	
	@FindBy (id="password")
	private WebElement txtPassword;
	
	@FindBy (id="login")
	private WebElement btnLogin;
	
	@FindBy (xpath = "//div[@class='auth_error']")
	private WebElement textErrorLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public WebElement getTextErrorLogin() {
		return textErrorLogin;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @description Method of Adactin Hotel Login by clicking login button through Mouse
	 * @date 08-July-2022
	 */
public void login(String username,String password) {
	
	sendKeys(getTxtUserName(), username);
	sendKeys(getTxtPassword(), password);
	toClick(getBtnLogin());
}
	
/**
 * 
 * @param username
 * @param password
 * @throws AWTException
 * @description Method of Adactin Hotel Login process by clicking login button with Enter Key
 * @date 08-July-2022
 */
public void loginWithEnter(String username,String password) throws AWTException {
	
	sendKeys(getTxtUserName(), username);
	sendKeys(getTxtPassword(), password);
	
	Robot robot = new Robot();
	
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);	
}	
	
	
	
	
	
}
