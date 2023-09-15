package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressInputBox;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordInputBox;
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;

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

	public String getPageTitle() {
		return driver.getTitle();
	}
}
