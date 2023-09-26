package com.tutorialNinja.functionalTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.LoginPage;
import com.tutorialNinja.pageObjectFactory.MyAccountPage;

public class R1dot1_TS002_LoginFunctionality extends InitialComponents {
	
	@Test(priority = 0, groups = {"smoke", "regression"}, description = "R1.1_TS002_TC001 Verify logging into the Application using valid credentials")
	public void r1dot1_TS002_TC001() throws IOException {
	HomePageObjects homePage=	launchApplicationHomePage();
	homePage.click_MyAccount();
	LoginPage loginPage= homePage.click_LoginButton();
	Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
	//loginPage.validateLoginPageAllFooterlinks();
	loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
	loginPage.setPassword_passwordInputBox("654321");
	MyAccountPage accountPage= loginPage.click_loginButton();
	Assert.assertEquals(accountPage.getPageTitle(), "My Account");
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
