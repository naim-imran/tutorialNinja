package com.tutorialNinja.pageObjectFactory;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadersAndFootersObjects {
	public HeadersAndFootersObjects(SearchContext driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//footer//div[@class='col-sm-3']//li")
	private List<WebElement> footerLinks;
	
	public void getFooterLink() {
		for (Iterator<WebElement> iterator = footerLinks.iterator(); iterator.hasNext();) {
			WebElement webElement =  iterator.next();
			System.out.println(webElement.getText());
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}
