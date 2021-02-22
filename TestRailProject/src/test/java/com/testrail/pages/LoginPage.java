package com.testrail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {


	//Page Factory -OR
	@FindBy(xpath ="//input[@id='name']") WebElement emailAddress;
	@FindBy(xpath= "//input[@id='password']") WebElement passwd;
	@FindBy(xpath="//button[@id='button_primary']") WebElement loginButton;
	
public LoginPage( ) {
	
		
		PageFactory.initElements(driver, this);		
	}
	
	
	public String validatePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage loginToTestRail(String email ,String pass) {
		
		emailAddress.sendKeys(email);
		passwd.sendKeys(pass);
		loginButton.click();		
		return new HomePage();
	}
	
	
}


