package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends CommonElements{
	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='col-sm-4']/div[@class='btn-group']/following-sibling::h1")
	private WebElement productName;
	
	public String getProductDetailsPageTitle() {
		return driver.getTitle();
	}
	
	public String getProductName() {
		return productName.getText();
		
		
	}
	
}
