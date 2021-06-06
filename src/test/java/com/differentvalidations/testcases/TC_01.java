package com.differentvalidations.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.differentvalidations.pageobjects.TestCase1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Test
	public void TC1 () throws InterruptedException {
		
		logger = Logger.getLogger("DifferentValidations");
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/accounts/emailsignup/");
		Thread.sleep(3000);
		TestCase1 tc1 = new TestCase1(driver);
		
		//validate text of login with facebook button
		boolean isTextDisplayed = tc1.checkButtonTextVisibility();
		boolean expected = true;
		if(isTextDisplayed == expected) {
			logger.info("Text is Displayed");
			
		}else {
			logger.info("Text is not Displayed");
			Assert.assertTrue(false);
		}
		
		//validate either the button is enabled
		boolean isEnabled_actual = tc1.isButtonEnabled();
		boolean isEnabled_expected = false;
		if(isEnabled_actual == isEnabled_expected) {
			logger.info("Button is not enabled");
			
		}else {
			logger.info("Button is enabled");
			Assert.assertTrue(false);
		}
		
		//validate either the check box is checked
		driver.get("https://www.classy.org/sso");
		Thread.sleep(2000);
		boolean actualCheckBox = tc1.isChecked();
		boolean expectedCheckBox = true;
		if(actualCheckBox == expectedCheckBox) {
			logger.info("Check box is checked");
		}else {
			logger.info("Check box is not checked");
			Assert.assertTrue(false);
		}
		
		//validate either the radio button is enabled
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		Thread.sleep(3000);
		boolean actualStatus = tc1.isRadioButtonEnabled();
		boolean expectedStatus = false;
		if(actualStatus == expectedStatus) {
			logger.info("Radio button is not checked");
		}else {
			logger.info("Radio button is checked");
			Assert.assertTrue(false);
		}
		
		driver.get("https://courses.letskodeit.com/practice");
		Thread.sleep(3000);
		
		//validate either the input field is displayed and present
		boolean actual = tc1.isTextBoxAppeared();
		expected = true;
		if(actual == expected) {
			logger.info("Text box is displayd");
		}else {
			logger.info("Text box is not displayed");
			Assert.assertTrue(false);
		}
		
		//validate either the input field is not displayed and present
		/*
		This time we are going validate that input field is not present. Note down, when we will click hide button...
		the element is not destroyed from DOM. It's code is present in DOM just we will not be able to see it over screen.
		*/
		actual = tc1.isTextBoxAppeared2();
		expected = false;
		if(actual == expected) {
			logger.info("Text box is not visible on screen but present in DOM");
		}else {
			logger.info("Text box is visible on screen and present in DOM");
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
