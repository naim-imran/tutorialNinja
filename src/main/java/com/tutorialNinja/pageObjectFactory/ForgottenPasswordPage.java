package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage extends CommonElements{

	private WebDriver driver;

	public ForgottenPasswordPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@id='input-email']")
	private WebElement emailInputBox;
	@FindBy(xpath= "//input[@class='btn btn-primary']")
	private WebElement continueButton;
	
	
	public String getForgottenPasswordPageTitle() {
		return driver.getTitle();
	}
	
	public void enterEmailInInputBox(String email) {
		emailInputBox.sendKeys(email);
	}
	
	public LoginPage clickContinueButton() {
		continueButton.click();
		return new LoginPage(driver);
	}

}
