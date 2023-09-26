package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	public WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/logout' and @class='list-group-item']")
	private WebElement logoutButtonRightColumn;
	
	public LogOutPage click_logoutButtonRightColumn() {
		logoutButtonRightColumn.click();
		return new LogOutPage(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
