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

public class OverviewPageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashBoardPage;
	OverviewPage overviewPage;
	
	OverviewPageTest(){
		
		   super();
		
	}
	
	@BeforeMethod
	public void setUp()throws IOException{
		
		intialize();
		loginPage = new LoginPage();
		dashBoardPage= new DashBoardPage();
		overviewPage = new OverviewPage();
		homePage = loginPage.loginToTestRail(prop.getProperty("email") , prop.getProperty("password"));
		overviewPage = dashBoardPage.clickProject();
			
	}
	
	@Test(priority=1)
	
	public void OverviewTitleTest() {
		
		Assert.assertTrue(overviewPage.verifyOverviewText(),"Overview link is missing in the page");
		
	}
	
	@Test(priority=2)
	public void addTestCase() {
		
		overviewPage.clickAddTestCase();
		
		
	}
	
	
	
	
	

}
