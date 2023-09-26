package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductDetailsPageTitle() {
		return driver.getTitle();
	}
}
