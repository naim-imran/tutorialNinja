package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HeadersAndFootersObjects;
import com.tutorialNinja.pageObjectFactory.ProductDetailsPage;
import com.tutorialNinja.pageObjectFactory.SearchResultPage;

public class R1dot2_TS005_ProductSearchFunctionality extends InitialComponents {

	@Test(priority = 1, description = "R1.2_TS005_TC001 As an user I should be able to search a product which is present in database.")
	public void r1dot2_TS005_TC001() {
		HeadersAndFootersObjects homePage = launchApplication().getHomePageHeadersAndFooters();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		String productName= "Mac";
		String expectedProduct= "apple MacBook";
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
		ProductDetailsPage productDetailsPage = searchResultPage.click_DesiredProduct(expectedProduct);
		Assert.assertEquals(productDetailsPage.getProductDetailsPageTitle(), expectedProduct);
		
	}
}
