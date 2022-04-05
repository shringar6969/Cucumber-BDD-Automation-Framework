package com.cucumberFramework.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;

public class LoginLogoutPage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='UserName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	WebElement captchaFrame;
	
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement captcha;
	
	@FindBy(xpath="//label[@id='userName-value']")
	WebElement profileUsername;
	
	@FindBy(xpath="//p[@id='name']")
	WebElement invalidUsernamePwd;
	
	
	@FindBy(xpath="//input[@id='searchBox']")
	WebElement getBookSearchField;
	
	
	@FindBy(xpath="//div[@class='text-right fullButton']//button[@id='addNewRecordButton']")
	WebElement addToYourCollection;
	

	@FindBy(xpath="//span[@title='Delete']")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[@id='closeSmallModal-ok']")
	WebElement deleteOkButton;
	
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='nav-tools']/a[@data-nav-role='signin']")
	WebElement SignInfromNav;
	
	@FindBy(xpath="//span[contains(text(),'Sign')]/parent::a")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='nav-shop']/a")
	public WebElement allShopNav;

	@FindBy(xpath="//span[@data-nav-panelkey='TvApplElecPanel']")
	public WebElement TvApplElecPanel;
	
	@FindBy(xpath="//span[contains(text(),'Headphones')]/parent::a")
	public WebElement headPhonesCatLnk;
	
	@FindBy(xpath="//div[@id='mainResults']/ul/li[1]/div/div/div/a[contains(@class,'access-detail-page')]")
	public WebElement firstHeadPhoneLnk;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	public WebElement cartButton;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> itemList;
	
	
	@FindBy(xpath="//div[contains(@class,'nav-search-field')]/input")
	public WebElement itemSearchField;
	
	@FindBy(xpath="//div[starts-with(@class,'sg-col-4')]/div[@class='sg-col-inner']/div/h5/a")
	public WebElement secondMacbookItem;
	
	@FindBy(xpath="//select[@id='quantity' or @name='quantity']")
	public List<WebElement> qtyField;
	
	
	
	
	WaitHelper waitHelper;
	
	
	public void button(String type) {
		driver.findElement(By.xpath("//button[text()='"+type+"']")).click();
	}
	
	public WebElement buttonType(String type) {
	return driver.findElement(By.xpath("//button[text()='"+type+"']"));
	}
	
	
	public LoginLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	
	public void enterfirstName(String firstName){
		this.firstName.sendKeys(firstName);
	}
	
	public void enterlastName(String lastName){
		this.lastName.sendKeys(lastName);
	}
	
	public void enteruserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void switchToCaptchaFrame(){
		waitHelper.WaitForFrame(captchaFrame, 10);
	}
	
	
	public void clickOnCaptcha(){
		waitHelper.WaitForClickable(captcha, 5);
	}
	public WebElement clickOnCaptcha1(){
		return captcha;
	}
	
	public String profileUsername(){
	 return	profileUsername.getText();
	}
	
	public WebElement getprofileUsername(){
		 return	profileUsername;
		}
		
	public WebElement getInvalidWarningMsg(){
		 return	invalidUsernamePwd;
		}
	
	public WebElement getBookSearchField(){
		 return	getBookSearchField;
		}
	
	public WebElement getAddToYourCollectionButton(){
		 return	addToYourCollection;
		}
	
	public void clickOnBookName(String bookname){
		driver.findElement(By.xpath("//a[text()='"+bookname+"']")).click();
		}
	
	public String getBookName(String bookname){
	 return	driver.findElement(By.xpath("//a[text()='"+bookname+"']")).getText();
		}
	

	public WebElement getDeleteButton(){
		 return	deleteButton;
		}
	
	public WebElement getDeleteOkButton(){
		 return	deleteOkButton;
		}
	
	
	

}
