package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductCatagoryPage {

	private WebDriver driver;

	public ProductCatagoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getProductCatagoryPageTitle() {
		return driver.getTitle();
	}
}
