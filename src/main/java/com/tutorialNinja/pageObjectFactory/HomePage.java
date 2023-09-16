package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.base.Reuseables;

public class HomePage  extends Reuseables{


	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HeadersAndFootersObjects getHomePageHeadersAndFooters() {
		return new HeadersAndFootersObjects(driver);
	}
}
