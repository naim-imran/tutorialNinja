package com.tutorialNinja.functionalTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HeadersAndFootersObjects;
import com.tutorialNinja.pageObjectFactory.LogOutPage;
import com.tutorialNinja.pageObjectFactory.LoginPage;
import com.tutorialNinja.pageObjectFactory.MyAccountPage;

public class R1dot1_TS003_LogoutFunctionality extends InitialComponents {
	
	@Test(description = "R1.1_TS003_TC001 Verify Logging out by selecting Logout option from 'My Account' drop menu")
	public void r1dot1_TS003_TC001() throws IOException {
	HeadersAndFootersObjects homePage=	launchApplicationHomePage().getHomePageHeadersAndFooters();
	homePage.click_MyAccount();
	LoginPage loginPage= homePage.click_LoginButton();
	Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
	loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
	loginPage.setPassword_passwordInputBox("654321");
	MyAccountPage accountPage= loginPage.click_loginButton();
	Assert.assertEquals(accountPage.getPageTitle(), "My Account");
	LogOutPage logOutPage= accountPage.click_logoutButtonRightColumn();
	logOutPage.getLogoutPageHeadersAndFooters().validateAllFooterLinks();;
	Assert.assertEquals(logOutPage.getPageTitle(), "Account Logout");
	
	}
	
}
