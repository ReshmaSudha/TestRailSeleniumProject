package com.testrail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseClass {
	
	//Page Factory -OR
	@FindBy(xpath ="//*[@id='navigation-projects']") 
	WebElement overviewText;	
    @FindBy(xpath ="//*[@id='sidebar-cases-add']") 
    WebElement addTestCaseLink;
    
    

	
public OverviewPage( ) {		
		
		PageFactory.initElements(driver, this);	
		
		}


  public Boolean verifyOverviewText() {
	
	 return overviewText.isDisplayed();
				
	}
  
  public AddTestCasePage clickAddTestCase() {
	  
	  addTestCaseLink.click();
	  return new AddTestCasePage();
	  
	  
	  
	  
  }



}
