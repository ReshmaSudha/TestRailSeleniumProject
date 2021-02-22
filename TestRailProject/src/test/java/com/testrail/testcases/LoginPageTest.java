package com.testrail.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testrail.pages.BaseClass;
import com.testrail.pages.HomePage;
import com.testrail.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
		
	LoginPageTest(){
		
		super();
	}
	
@BeforeMethod
public void setUp()throws IOException{
	
	intialize();
	loginPage = new LoginPage();
		
}
			
	@Test(priority=1)
	
	public void loginPageTitleTest() {
		
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "Login - TestRail");
			
	}

		
	@Test(priority=2)
	public void loginApp() {
					
		homePage = loginPage.loginToTestRail(prop.getProperty("email") , prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		
	driver.quit();
		
		
	}
	
	
	
}

