package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.ForgottenPasswordPage;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.LoginPage;

public class R1dot1_TS004_ForgottenPasswordFunctionality extends InitialComponents {
	
	
	//jira link: https://naayeem.atlassian.net/browse/TN-53
	@Test(priority = 1, groups = {"smoke", "possitive"}, description = "R1.1_TS004_TC001 as a Registered user I should be able to reset my password by using \"Forgotten Password\" link in \"Returning Customer\" Login box")
	public void r1dot1_TS004_TC001() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		ForgottenPasswordPage forgottenPasswordPage = loginPage.clickForgottenPasswordInReturningCustomerBox();
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageTitle(),"Forgot Your Password?");
		forgottenPasswordPage.enterEmailInInputBox("dwana.ondricka@gmail.com");
		LoginPage loginPage2 = forgottenPasswordPage.clickContinueButton();
		Assert.assertEquals(loginPage2.getHomePageTitle(), "Account Login");
		Assert.assertEquals(loginPage2.getEmailSentConfirmationText(), "An email with a confirmation link has been sent your email address.");
	}
	
	
}
