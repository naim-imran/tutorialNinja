package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.base.Reuseables;

public class LogOutPage extends Reuseables {
	private WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public HeadersAndFootersObjects getLogoutPageHeadersAndFooters() {
		return new HeadersAndFootersObjects(driver);
	}
}
