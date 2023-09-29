package com.tutorialNinja.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends CommonElements{
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//input[@id='input-firstname']")
	private WebElement firstNameEditBox;
	@FindBy(xpath= "//input[@id='input-lastname']")
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
	@FindBy(xpath= "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyErrorMsg;
	@FindBy(xpath= "//input[@name='firstname']/following-sibling::div[@class='text-danger']")
	private WebElement firstnameErrorMessage;
	@FindBy(xpath= "//input[@name='lastname']/following-sibling::div[@class='text-danger']")
	private WebElement lastnameErrorMessage;
	@FindBy(xpath= "//input[@name='email']/following-sibling::div[@class='text-danger']")
	private WebElement emailErrorMessage;
	@FindBy(xpath= "//input[@name='telephone']/following-sibling::div[@class='text-danger']")
	private WebElement phoneErrorMessage;
	@FindBy(xpath= "//input[@name='password']/following-sibling::div[@class='text-danger']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath= "//input[@name='confirm']/following-sibling::div[@class='text-danger']")
	private WebElement confirmPasswordErrorMessage;
	
	
	
	
	
	public String getRegistrationPageTitle() {
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
	public String getPrivacyPolicyErrorMsg() {
		return privacyPolicyErrorMsg.getText();
	}
	public String getFirstnameErrorMessage() {
		return firstnameErrorMessage.getText();
	}
	public String getLastnameErrorMessage() {
		return lastnameErrorMessage.getText();
	}
	public String getEmailErrorMessage() {
		return emailErrorMessage.getText();
	}
	public String getPhoneErrorMessage() {
		return phoneErrorMessage.getText();
	}
	public String getPasswordErrorMessage() {
		return passwordErrorMessage.getText();
	}
	public String getConfirmPasswordErrorMessage() {
		return confirmPasswordErrorMessage.getText();
	}
	
	
}
