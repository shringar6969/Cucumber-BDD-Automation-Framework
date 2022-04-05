package com.cucumberFramework.stepdefinitions;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.LoginLogoutPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginLogoutPageStepDefinitions extends TestBase {

	LoginLogoutPage loginPage = new LoginLogoutPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// waitHelper = new WaitHelper(driver);
	}

	@Then("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		js.executeScript("arguments[0].scrollIntoView();",loginPage.buttonType(arg1));
		loginPage.button(arg1);
	}

	@When("^I enter registration fields$")
	public void i_enter_registration_fields(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		loginPage.enterfirstName(data.get(1).get(0));
		loginPage.enterlastName(data.get(1).get(1));
		loginPage.enteruserName(data.get(1).get(2));
		loginPage.enterPassword(data.get(1).get(3));

		loginPage.switchToCaptchaFrame();
//		loginPage.clickOnCaptcha();
		js.executeScript("arguments[0].click();", loginPage.clickOnCaptcha1());
	}

	@When("^I enter Valid Credentials$")
	public void i_enter_Valid_Credentials(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		loginPage.enteruserName(data.get(1).get(0));
		loginPage.enterPassword(data.get(1).get(1));
	}

	@Then("^I validate the \"([^\"]*)\" username$")
	public void i_validate_the_username(String arg1) throws Throwable {
		boolean username = loginPage.getprofileUsername().isDisplayed();
		String usernameText = loginPage.profileUsername();
		Assert.assertTrue(username);
		Assert.assertEquals(arg1, usernameText);

	}

	@Then("^I validate the invalid warning message$")
	public void i_validate_the_invalid_warning_message() throws Throwable {
		boolean invalid = loginPage.getInvalidWarningMsg().isDisplayed();
		Assert.assertTrue(invalid);
	}

	@Then("^I search the \"([^\"]*)\" book$")
	public void i_search_the_book(String arg1) throws Throwable {
		
		loginPage.getBookSearchField().sendKeys(arg1);
	}

	@Then("^I click on \"([^\"]*)\" book name$")
	public void i_click_on_book_name(String bookName) throws Throwable {
		loginPage.clickOnBookName(bookName);
	}

	@Then("^I click on add to your collection button$")
	public void i_click_on_add_to_your_collection_button() throws Throwable {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	//	js.executeScript("arguments[0].click();", loginPage.getAddToYourCollectionButton());
		loginPage.getAddToYourCollectionButton().click();
		waitHelper.WaitForAlert(5);
		driver.switchTo().alert().accept();
	}

	@Then("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String arg1) throws Throwable {
		driver.navigate().to(arg1);
	}

	@Then("^I validate the \"([^\"]*)\" book is added$")
	public void i_validate_the_book_is_added(String arg1) throws Throwable {
		Assert.assertEquals(loginPage.getBookName(arg1), arg1);
	}

	@Then("^I delete the added book$")
	public void i_delete_the_added_book() throws Throwable {
//		loginPage.getDeleteButton().click();
//		loginPage.getDeleteOkButton().click();
		waitHelper.WaitForAlert(5);
		driver.switchTo().alert().accept();
	}
}
