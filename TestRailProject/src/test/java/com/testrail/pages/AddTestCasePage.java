package com.testrail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTestCasePage extends BaseClass {
	
	//Page Factory -OR
		@FindBy(xpath ="//*[@id='navigation-projects']") 
		WebElement overviewText;	
	    @FindBy(xpath ="//*[@id='sidebar-cases-add']") 
	    WebElement addTestCaseLink;
	    @FindBy(xpath ="//input[@id='title']") 
	    WebElement enterTitle;
	    @FindBy(xpath ="//textarea[@id='custom_steps']")
	    WebElement enterSteps;	    
	    @FindBy(xpath ="//*[@id='accept']")
	    WebElement clickAddTestCaseButton; 
	    @FindBy(xpath ="//div[@class='message message-success']")
	    WebElement successMessage;
	    
	  
	     
	    
	 public AddTestCasePage( ) {		
			
	  PageFactory.initElements(driver, this);			
	}
	    
	 public String validateAddTestCasePageTitle() {
			
	  return driver.getTitle();
					
	}   
	 
	 public void  addNewTestcase() {
		 
		enterTitle.sendKeys("TestProject");	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Making the dropdown visibility to visible from none as it was hidden 	
		
		js.executeScript("document.getElementById('priority_id').style.display='block'");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("priority_id")));
		Select typedropdown = new Select (selectDropdown );	
		typedropdown.selectByVisibleText("Low");
		enterSteps.sendKeys("Sample Steps");
		JavascriptExecutor ex = (JavascriptExecutor)driver;
 	    ex.executeScript("arguments[0].click();", clickAddTestCaseButton);   	
		
	   }
	 
	 public Boolean validateTestcaseSuccess() {
		 
		 return successMessage.isDisplayed();
	 
	 }

}
