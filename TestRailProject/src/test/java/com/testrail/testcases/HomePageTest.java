package com.testrail.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testrail.pages.BaseClass;
import com.testrail.pages.DashBoardPage;
import com.testrail.pages.HomePage;
import com.testrail.pages.LoginPage;

public class HomePageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashBoardPage;
	
	HomePageTest(){
		
		   super();
		
	}
	
	@BeforeMethod
	public void setUp()throws IOException{
		
		intialize();
		loginPage = new LoginPage();
		homePage = loginPage.loginToTestRail(prop.getProperty("email") , prop.getProperty("password"));
			
	}
	
 @Test(priority=1)
	
	public void homePageTitleTest() {
		
		String title = homePage.validateHomePageTitleTest();
		Assert.assertEquals(title, "All Projects - TestRail");
			
	}
 
 @Test(priority=2)
	
	public void clickAddProjectLink() {
		
		homePage.clickAddProject(prop.getProperty("projectName"));
		String message=  homePage.captureProjectSucess();
		Assert.assertEquals(message, "Successfully added the new project.");
			
	}
 
 @Test(priority=3)
	
	public void clickDashboard() {
		
	 dashBoardPage = homePage.clickDashboard();
	 
	}
 
  	
 @AfterMethod
	
	public void tearDown(){		
	driver.quit();
	
	}
	
	
 
	
	

}
