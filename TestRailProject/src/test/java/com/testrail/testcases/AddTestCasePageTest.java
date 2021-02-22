package com.testrail.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testrail.pages.AddTestCasePage;
import com.testrail.pages.BaseClass;
import com.testrail.pages.DashBoardPage;
import com.testrail.pages.HomePage;
import com.testrail.pages.LoginPage;
import com.testrail.pages.OverviewPage;

public class AddTestCasePageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashBoardPage;
	OverviewPage overviewPage;
	AddTestCasePage addTestCasePage;
	
	
	AddTestCasePageTest(){
		
		   super();
		
	}
	
	@BeforeMethod
	public void setUp()throws IOException{
		
		intialize();
		loginPage = new LoginPage();
		dashBoardPage= new DashBoardPage();
		overviewPage = new OverviewPage();
		addTestCasePage = new AddTestCasePage();
		homePage = loginPage.loginToTestRail(prop.getProperty("email") , prop.getProperty("password"));
		overviewPage = dashBoardPage.clickProject();
		overviewPage.clickAddTestCase();
		
	}
	
@Test(priority=1)
	
	public void VerifyTestCasePageTitle() {
		
		String title = addTestCasePage.validateAddTestCasePageTitle();
		Assert.assertEquals(title, "Add Test Case - TestRail");
		
	}

@Test(priority=2)

  public void addNewTestCase() {
	
	addTestCasePage.addNewTestcase();
	addTestCasePage.validateTestcaseSuccess();
	
		
}


			
	

}
