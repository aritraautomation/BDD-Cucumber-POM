package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//By Locators:	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?1");
	
	
	//LoginPage class constructor:	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		 driver.findElement(emailId).sendKeys(username);;
	}
	
	public void enterPassword(String pwd) {
		 driver.findElement(password).sendKeys(pwd);;
	}
	
	public void clickSignInButton() {
		driver.findElement(signInBtn).click();
	}
	
	public AccountPage doLogin(String un, String pwd) {
		 driver.findElement(emailId).sendKeys(un);;
		 driver.findElement(password).sendKeys(pwd);;
		 driver.findElement(signInBtn).click();

		 return new AccountPage(driver);
	}
	
		
}
