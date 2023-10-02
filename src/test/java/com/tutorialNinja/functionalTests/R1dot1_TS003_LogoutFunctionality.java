package com.tutorialNinja.functionalTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.LogOutPage;
import com.tutorialNinja.pageObjectFactory.LoginPage;
import com.tutorialNinja.pageObjectFactory.MyAccountPage;

public class R1dot1_TS003_LogoutFunctionality extends InitialComponents {

	@Test(priority = 1, groups = { "smoke",
			"possitive" }, description = "R1.1_TS003_TC001 Verify Logging out by selecting Logout option from 'My Account' drop menu")
	public void r1dot1_TS003_TC001() throws IOException {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		MyAccountPage accountPage = loginPage.click_loginButton();
		Assert.assertEquals(accountPage.getPageTitle(), "My Account");
		homePage.click_MyAccountDropLisButton();
		LogOutPage logOutPage = accountPage.clickAccountDropDownLogoutButton();
		Assert.assertEquals(logOutPage.getPageTitle(), "Account Logout");
	}

	@Test(priority = 2, groups = {
			"smoke","possitive"}, description = "R1.1_TS003_TC002 Verify Logging out by selecting Logout option from 'Right Column' options")
	public void r1dot1_TS003_TC002() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		MyAccountPage accountPage = loginPage.click_loginButton();
		Assert.assertEquals(accountPage.getPageTitle(), "My Account");
		LogOutPage logOutPage = accountPage.click_logoutButtonRightColumn();
		Assert.assertEquals(logOutPage.getPageTitle(), "Account Logout");
	}
	
	@Test(priority = 3, groups = {"smoke","possitive"}, description = "R1.1_TS003_TC003 Verify the Application session status, after logging and closing the Browser without logging out" )
	public void r1dot1_TS003_TC003() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		MyAccountPage accountPage = loginPage.click_loginButton();
		Assert.assertEquals(accountPage.getPageTitle(), "My Account");
		quitDriver();
		HomePageObjects homePage1 = launchApplicationHomePage();
		homePage1.click_MyAccountDropLisButton();
		MyAccountPage accountPage2 = homePage1.click_MyAccount();
		Assert.assertEquals(accountPage2.getPageTitle(), "My Account");
	}
}
