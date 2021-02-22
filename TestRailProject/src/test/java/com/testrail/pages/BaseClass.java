package com.testrail.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	
	public static WebDriver driver ;
	public  static Properties prop;
	
	
	public BaseClass(){
		
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/16693/eclipse-workspace/TestRailProject/src/test/java/"
					 +"com/testrail/config/config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void intialize() {
		
		String browserName = prop .getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		driver.get(prop.getProperty("qaURL"));
		
	}
	
}
