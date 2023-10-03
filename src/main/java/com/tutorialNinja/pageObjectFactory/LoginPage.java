package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonElements{
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressInputBox;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordInputBox;
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;
	@FindBy(xpath= "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginErrorMsg;
	@FindBy(xpath= "//div[@class='form-group']//a[text()='Forgotten Password']")
	private WebElement forgottenPasswordLinkButtonReturningCustomerBox;
	@FindBy(xpath= "//div[@class='alert alert-success alert-dismissible']")
	private WebElement emailSentConfirmationText;

	public void setEmail_emailAddressInputBox(String email) {
		emailAddressInputBox.sendKeys(email);
	}

	public void setPassword_passwordInputBox(String password) {
		passwordInputBox.sendKeys(password);
	}

	public MyAccountPage click_loginButton() {
		loginButton.click();
		return new MyAccountPage(driver);
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginErrorMsg() {
		return loginErrorMsg.getText();
	}
	
	public ForgottenPasswordPage clickForgottenPasswordInReturningCustomerBox() {
		forgottenPasswordLinkButtonReturningCustomerBox.click();
		return new ForgottenPasswordPage(driver);
	}
	public String getEmailSentConfirmationText() {
		return emailSentConfirmationText.getText();
	}
	
	
}
