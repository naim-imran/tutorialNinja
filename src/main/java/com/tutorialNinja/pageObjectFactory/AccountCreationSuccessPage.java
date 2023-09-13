package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationSuccessPage {
	private WebDriver driver;
	public AccountCreationSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@id='content']/h1")
	private WebElement confirmationText;
	@FindBy(xpath= "//a[@class='btn btn-primary' and text()='Continue']")
	private WebElement continueButton;
	
	
	
	public String getAccountCreateConfirmationText() {
		return  confirmationText.getText();
	}
	public MyAccountPage clickContinueButton() {
		continueButton.click();
		return new MyAccountPage(driver);
	}
	
	
}
