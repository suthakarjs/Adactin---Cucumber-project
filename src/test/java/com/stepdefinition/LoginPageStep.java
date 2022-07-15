package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Suthakar JS
 * @description Describes the different steps of Login process and also it's Verification steps too
 * @date 08-July-2022	
 *
 */
public class LoginPageStep extends BaseClass {

PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin login page")
	public void adactinLoginPage() {
		
	}

	@When("User should perform login with {string} and {string}")
	public void loginWithValidDatas(String userName, String password) throws IOException {
		pom.getLoginPage().login(userName, password);
	}

	@When("User should perform login with {string} , {string} and click Enter key")
	public void loginWithEnterKey(String userName, String password) throws IOException {
		pom.getLoginPage().login(getPropertyFiles("username"), getPropertyFiles("password"));
	}

	@Then("User should verify after login an Error message which contains {string}")
	public void loginErrorMessage(String expectedLoginErrorMessage) {
		Assert.assertTrue("Error Verification - After Invalid Login", pom.getLoginPage().getTextErrorLogin().getText().contains(expectedLoginErrorMessage));
	}

	
}
