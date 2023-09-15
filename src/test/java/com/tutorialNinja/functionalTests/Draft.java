package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.pageObjectFactory.HomePage;
import com.tutorialNinja.pageObjectFactory.SearchResultPage;

public class Draft extends com.tutorialNinja.base.InitialComponents {
	String productName = "mac";

	@Test
	public void velidateLogoText() {
		HomePage homePage = launchApplication();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		// System.out.println(searchResultPage.getSearchedItemText());
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
	}
	
	@Test
	public void velidateLogoText01() {
		HomePage homePage = launchApplication();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		// System.out.println(searchResultPage.getSearchedItemText());
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
	}
	
	@Test
	public void velidateLogoText02() {
		HomePage homePage = launchApplication();
		homePage.getFooterLink();
	}
}
