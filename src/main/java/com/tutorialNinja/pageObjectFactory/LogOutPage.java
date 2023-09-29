package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends CommonElements {
	private WebDriver driver;

	public LogOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void validateLogoutPageFooterLinks() {
		 validateAllFooterLinks(driver);
	}
}
