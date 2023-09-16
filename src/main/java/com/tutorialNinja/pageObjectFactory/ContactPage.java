package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	private WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getContactPageTitle() {
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
