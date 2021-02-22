package com.testrail.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	//Page Factory -OR
		@FindBy(xpath ="//*[@id='sidebar-projects-add']") WebElement addProjectLink;
		@FindBy(xpath= "//input[@id='name']") WebElement enterName;
		@FindBy(xpath= "//button[@id='accept']") WebElement addProjectButton;
		@FindBy(xpath= "//div[@class='message message-success']") WebElement successMessage;
		@FindBy(xpath= "//*[@id='navigation-dashboard']") WebElement dashboardLink;
		
		
		public HomePage( ) {			
			PageFactory.initElements(driver, this);		
		}
		
		public String validateHomePageTitleTest() {
			
			return driver.getTitle();
			
		}
		
       public void clickAddProject(String projName) {
    	   addProjectLink.click();
    	   enterName.sendKeys(projName);
    	   JavascriptExecutor ex = (JavascriptExecutor)driver;
    	   ex.executeScript("arguments[0].click();", addProjectButton);   	 
						
		}
       
       
       public String captureProjectSucess() {
    	   
    	   WebElement result = successMessage;
    	   String message = result.getText();
    	   return message;
    	   
       }
       
       public DashBoardPage clickDashboard() {
    	   
    	   dashboardLink.click();
    	   return new DashBoardPage(); 
    	   
    	   
       }

}
