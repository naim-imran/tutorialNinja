package com.tutorialNinja.functionalTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.AccountCreationSuccessPage;
import com.tutorialNinja.pageObjectFactory.HomePage;
import com.tutorialNinja.pageObjectFactory.MyAccountPage;
import com.tutorialNinja.pageObjectFactory.RegistrationPage;

public class R1dot1_TS_001_RegisterFunctionality extends InitialComponents {
	@Test(priority = 0, description = "R1.1_TS_001_TC_RF_001 As a user I should be able to Register an Account by providing only the Mandatory fields")
	public void R1dot1_TS_001_TC_RF_001() {
		HashMap<String, String> testData = getFakerTestData();
		HomePage homePage = launchApplication();
		homePage.click_MyAccount();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getPagetitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		registrationPage.checkPrivacyAndPolicyCheckBox();
		AccountCreationSuccessPage accountCreationSuccessPage = registrationPage.clickContinue();
		Assert.assertEquals(accountCreationSuccessPage.getAccountCreateConfirmationText(),
				"Your Account Has Been Created!");
		System.out.println(accountCreationSuccessPage.getAccountCreateConfirmationText());
		MyAccountPage myAccountPage = accountCreationSuccessPage.clickContinueButton();
		Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
		System.out.println(myAccountPage.getPageTitle());
	}

	@Test(priority = 1, description = "R1.1_TS_001_TC_RF_002 As a registered user I should get 'Thank you for registering' email is sent to the registered email address as a confirmation for registering the account")
	public void R1dot1_TS_001_TC_RF_003() {
		HashMap<String, String> testData = getFakerTestData();
		HomePage homePage = launchApplication();
		homePage.click_MyAccount();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getPagetitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		registrationPage.clickSubscribeNewletterYesButton();
		registrationPage.checkPrivacyAndPolicyCheckBox();
		AccountCreationSuccessPage accountCreationSuccessPage = registrationPage.clickContinue();
		Assert.assertEquals(accountCreationSuccessPage.getAccountCreateConfirmationText(),
				"Your Account Has Been Created!");
		System.out.println(accountCreationSuccessPage.getAccountCreateConfirmationText());
		MyAccountPage myAccountPage = accountCreationSuccessPage.clickContinueButton();
		Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
		System.out.println(myAccountPage.getPageTitle());
	}
}
