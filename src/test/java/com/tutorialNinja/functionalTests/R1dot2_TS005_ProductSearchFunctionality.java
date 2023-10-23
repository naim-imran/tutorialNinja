package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.ProductDetailsPage;
import com.tutorialNinja.pageObjectFactory.SearchResultPage;

public class R1dot2_TS005_ProductSearchFunctionality extends InitialComponents {
	
	
	// jira link: https://naayeem.atlassian.net/browse/TN-43
	@Test(priority = 1, groups = {SMOKE,POSSITIVE}, description = "R1.2_TS005_TC001 As an user I should be able to search a product which is present in database.")
	public void r1dot2_TS005_TC001() {
		HomePageObjects homePage = launchApplicationHomePage();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		String productName= "Mac";
		String expectedProduct= "MacBook";
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
		ProductDetailsPage productDetailsPage = searchResultPage.click_DesiredProduct(expectedProduct);
		Assert.assertEquals(productDetailsPage.getProductDetailsPageTitle(), expectedProduct);
		
	}
	// jira link: https://naayeem.atlassian.net/browse/TN-55
	@Test(groups = {SMOKE,POSSITIVE}, dataProvider = "productList", priority = 2, description = "R1.2_TS005_TC024 Verify user can select a product from featured product list from HomePage")
	public void R1dot2_TS005_TC024(String name) {
		String productName = name;
		HomePageObjects homePage = launchApplicationHomePage();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		ProductDetailsPage ProductDetailsPage = homePage.clickHomePageFeaturedProduct(productName);
		Assert.assertEquals(ProductDetailsPage.getProductName(), productName);
	}
	
	@DataProvider
	public String[] productList() {
	String[] product=  {"MacBook", "iPhone","Apple Cinema 30\"","Canon EOS 5D"};
	return product;
	
	}
	
}

