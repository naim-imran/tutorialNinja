package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='logo']//a")
	private WebElement logo;
	@FindBy(xpath = "//input[@name='search'and @class='form-control input-lg']")
	private WebElement searchBox;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath= "//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']/following-sibling::span")
	private WebElement myAccountDropList;
	@FindBy(xpath= "//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='Register']")
	private WebElement registerButton;
	@FindBy(xpath= "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")
	private WebElement loginButton;
	
	
	
	public String getLogoText() {
		return logo.getText();
	}

	public void setText(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public SearchResultPage clickSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	public void click_MyAccount() {
		myAccountDropList.click();
	}
	
	public RegistrationPage click_registerButton() {
		registerButton.click();
		return new RegistrationPage(driver);
	}
	public LoginPage click_LoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}

}
