package com.testrail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseClass{
	
	
	//Page Factory -OR
	@FindBy(xpath ="//div[@class='summary-title text-ppp']//a[contains(text(),'SimplrTest')]") 
	WebElement projectLink;

		
	public DashBoardPage( ) {		
		
		PageFactory.initElements(driver, this);	
		
		}
			
      public String validateDashBoardPageTitleTest() {
				
		return driver.getTitle();
				
	}
      
      public OverviewPage clickProject() {
    	  
    	  projectLink.click();
    	  return new OverviewPage();
   	  	 						
		}
      

      
    
			
	
	
	
	

}
