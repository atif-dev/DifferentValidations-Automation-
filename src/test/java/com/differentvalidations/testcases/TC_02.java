package com.differentvalidations.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.differentvalidations.pageobjects.TestCase2;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_02 {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Test
	public void TC2() throws InterruptedException {
		
		logger = Logger.getLogger("DifferentValidations");
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.expedia.com/");
		driver.manage().window().maximize();
		
		//check the visibility of child age field
		TestCase2 tc2 = new TestCase2(driver);
		tc2.clickFlightsLink();
		Thread.sleep(1000);
		tc2.clickOneTravelerLink();
		Thread.sleep(1000);
		tc2.plusChildren();
		Thread.sleep(1000);
		
		//check the visibility of child age field
		boolean expected = true;
		boolean actual = tc2.checkVisibility();
		if(expected == actual) {
			logger.info("child age drop down section is diplayed");
		}else {
			Assert.assertTrue(false);
		}
		
		/*
		 * if we comment tc2.plusChildren(); in code then we will get unable to find element error.
		 * Actually at web site interface when we increment children then child age field connects itself to DOM
		 * and when we click negative then child age field is destroyed from DOM.
		 * In inspection tool if we copy the id of an element and later on if we destroy this element then we will not able to
		 * search it by id because it is no longer exists in DOM.
		 */
		
		
	}
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
