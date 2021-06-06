package com.differentvalidations.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase1 {
	
	WebDriver ldriver;
	public TestCase1(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	boolean flag;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"react-root\"]/section/main/div/div/div[1]/div/form/div[1]/button")
	@CacheLookup
	WebElement fbLoginButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"react-root\"]/section/main/div/div/div[1]/div/form/div[7]/div/button")
	@CacheLookup
	WebElement signUpButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/form/fieldset[3]/label/input[2]")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"sex-0\"]")
	@CacheLookup
	WebElement maleRadioButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"displayed-text\"]")
	@CacheLookup
	WebElement inputField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"hide-textbox\"]")
	@CacheLookup
	WebElement hide;
	
	public Boolean checkButtonTextVisibility() {
		flag =  fbLoginButton.isDisplayed(); //isDisplayed method in Selenium verifies if a certain element is present and displayed
		return flag;
	}
	
	public Boolean isButtonEnabled() {
		flag =  signUpButton.isEnabled(); //isEnabled is used to check either the button is enabled
		return flag;
	}
	
	public Boolean isChecked() {
		flag =  checkBox.isSelected(); //isSelectd is used to check either the check box is checked
		return flag;
	}
	
	public Boolean isRadioButtonEnabled() {
		//maleRadioButton.click();
		flag =  maleRadioButton.isSelected(); //isSelectd is also used for checking either the radio button is enabled
		return flag;
	}
	
	public Boolean isTextBoxAppeared() {
		flag = inputField.isDisplayed(); //isDisplayed method in Selenium verifies if a certain element is present and displayed
		return flag;
	}
	
	public Boolean isTextBoxAppeared2() throws InterruptedException {
		hide.click();
		Thread.sleep(1000);
		flag = inputField.isDisplayed(); //isDisplayed method in Selenium verifies if a certain element is present and displayed
		return flag;
	}

}
