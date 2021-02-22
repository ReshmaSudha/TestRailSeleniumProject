package com.testrail.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testrail.pages.BaseClass;
import com.testrail.pages.DashBoardPage;
import com.testrail.pages.HomePage;
import com.testrail.pages.LoginPage;
import com.testrail.pages.OverviewPage;

public class DashBoardPageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashBoardPage;
	OverviewPage overviewPage;
	
	DashBoardPageTest(){
		
		   super();
		
	}
	
	@BeforeMethod
	public void setUp()throws IOException{
		
		intialize();
		loginPage = new LoginPage();
		dashBoardPage= new DashBoardPage();
		homePage = loginPage.loginToTestRail(prop.getProperty("email") , prop.getProperty("password"));
			
	}
	
 @Test(priority=1)
		
		public void dashBoardTitleTest() {
			
			String title = dashBoardPage.validateDashBoardPageTitleTest();
			Assert.assertEquals(title, "All Projects - TestRail");
				
		}
	
@Test(priority=2)
	
	public void clickProjectLink() {
				
	overviewPage = dashBoardPage.clickProject();
				
	}

}
