package com.tutorialNinja.pageObjectFactory;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends CommonElements {
	

	
	
	public HomePageObjects(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath= "//div[@class='product-thumb transition']")
	private List<WebElement> featuredProducts;
	
	
	
	public void clickHomePageFeaturedProduct(String expectedProduct) {
	
		for (Iterator<WebElement> iterator = featuredProducts.iterator(); iterator.hasNext();) {
			WebElement webElement =  iterator.next();
			if (webElement.findElement(By.xpath("div[@class='caption']")).getText().contains(expectedProduct)) {
				webElement.click();
				break;
			}
			
		}
	}
	


}
