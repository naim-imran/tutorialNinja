package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePage;
import com.tutorialNinja.pageObjectFactory.LoginPage;
import com.tutorialNinja.pageObjectFactory.MyAccountPage;

public class R1dot1_TS002_LoginFunctionality extends InitialComponents {
	@Test(description = "R1.1_TS002_TC001 Verify logging into the Application using valid credentials")
	public void r1dot1_TS002_TC001() {
	HomePage homePage=	launchApplication();
	homePage.click_MyAccount();
	LoginPage loginPage= homePage.click_LoginButton();
	Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
	loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
	loginPage.setPassword_passwordInputBox("654321");
	MyAccountPage accountPage= loginPage.click_loginButton();
	Assert.assertEquals(accountPage.getPageTitle(), "My Account");
	}
	
	
	
	
	
	
	
	
	
	
	

}
