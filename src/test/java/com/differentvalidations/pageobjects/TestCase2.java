package com.differentvalidations.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase2 {

	WebDriver ldriver;
	public TestCase2(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"uitk-tabs-button-container\"]/li[2]/a")
	@CacheLookup
	WebElement flights;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"adaptive-menu\"]/a")
	@CacheLookup
	WebElement oneTravelerLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[2]/div/button[2]")
	@CacheLookup
	WebElement plusChildren;
	
	@FindBy(how = How.ID, using = "child-age-input-0-0")
	@CacheLookup
	WebElement childrenSection;
	
	public void clickFlightsLink() {
		flights.click();
	}
	
	public void clickOneTravelerLink() {
		oneTravelerLink.click();
	}
	
	public void plusChildren() {
		plusChildren.click();
	}
	
	public boolean checkVisibility() {
		return childrenSection.isDisplayed();
	}
	
	
}
