package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameEditBox;
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameEditBox;
	@FindBy(xpath= "//input[@id='input-email']")
	private WebElement emailEditBox;
	@FindBy(xpath= "//input[@id='input-telephone']")
	private WebElement telephoneEditBox;
	@FindBy(xpath= "//input[@id='input-password']")
	private WebElement passwordEditBox;
	@FindBy(xpath= "//input[@id='input-confirm']")
	private WebElement passwordConfirmEditBox;
	@FindBy(xpath= "//input[@name='agree']")
	private WebElement privacyAndPolicyCheckBox;
	@FindBy(xpath= "//input[@class='btn btn-primary']")
	private WebElement continueButton;
	@FindBy(xpath= "//label[text()='Yes']/input")
	private WebElement subscribeNewletterYesButton;
	
	
	
	public String getPagetitle() {
		 return driver.getTitle();
	}
	public void enterFirstName(String firstName) {
		firstNameEditBox.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		lastNameEditBox.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		emailEditBox.sendKeys(email);
	}
	public void enterTelephone(String telephone) {
		telephoneEditBox.sendKeys(telephone);
	}
	public void enterPassword(String password) {
		passwordEditBox.sendKeys(password);
	}
	public void confirmPassword(String confirmPassword) {
		passwordConfirmEditBox.sendKeys(confirmPassword);
	}
	public void checkPrivacyAndPolicyCheckBox() {
		privacyAndPolicyCheckBox.click();
	}
	public AccountCreationSuccessPage clickContinue() {
		continueButton.click();
		return new AccountCreationSuccessPage(driver);
	}
	public void clickSubscribeNewletterYesButton() {
		subscribeNewletterYesButton.click();
		
	}
}
