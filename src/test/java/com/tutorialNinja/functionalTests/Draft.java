package com.tutorialNinja.functionalTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HeadersAndFootersObjects;
import com.tutorialNinja.pageObjectFactory.HomePage;
import com.tutorialNinja.pageObjectFactory.SearchResultPage;

public class Draft extends InitialComponents {
	String productName = "mac";

	@Test
	public void velidateLogoText() throws InterruptedException {
		HeadersAndFootersObjects headersAndFootersObjects = launchApplication().getHomePageHeadersAndFooters();
		Assert.assertEquals("Qafox.com", headersAndFootersObjects.getLogoText());
		
		headersAndFootersObjects.click_CurrencyDropDown();
		headersAndFootersObjects.select_Currency_€Euro();
		headersAndFootersObjects.click_telephone();
		Thread.sleep(10000);
	}
	
	@Test
	public void velidateLogoText01() {
		HeadersAndFootersObjects homePage = launchApplication().getHomePageHeadersAndFooters();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		// System.out.println(searchResultPage.getSearchedItemText());
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
	}
	
	@Test
	public void velidateLogoText02() throws IOException {
		HomePage homePage = launchApplication();
		homePage.getHomePageHeadersAndFooters().validateAllFooterLinks();
		
		/*
		 * SoftAssert softAssert= new SoftAssert();
		 * List<WebElement> homePageFooterLinks = homePage.getAllFooterLinks(); byte
		 * count= 1; for (Iterator<WebElement> iterator =
		 * homePageFooterLinks.iterator(); iterator.hasNext();) { WebElement webElement
		 * = iterator.next(); String link = webElement.getAttribute("href"); int
		 * responseCode = validateLink(link); if (responseCode>200) {
		 * softAssert.assertTrue(false); }else { System.out.println(count+ ": " + link +
		 * " responseCode= " + responseCode + ", is valid");
		 * softAssert.assertTrue(true); } count++; }
		 */
	}
	
	
	
}
