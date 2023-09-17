package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HeadersAndFootersObjects;
import com.tutorialNinja.pageObjectFactory.ProductsComparisonPage;
import com.tutorialNinja.pageObjectFactory.SearchResultPage;

public class R1dot2_TS006_ProductCompareFunctionality extends InitialComponents{
	@Test(description = "R1.2_TS006_TC001 As an user I should be able to select products for comparison.")
	public void r1dot2_TS006_TC001() {
		HeadersAndFootersObjects homePage = launchApplication().getHomePageHeadersAndFooters();
		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		String productName= "Mac";
		homePage.setText(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());
		searchResultPage.click_productCompareButton("iMac");
		searchResultPage.click_productCompareButton("MacBook");
		searchResultPage.click_productCompareButton("MacBook Air");
		searchResultPage.click_productCompareButton("MacBook Pro");
		ProductsComparisonPage productsComparisonPage= searchResultPage.click_comparisonLinkButton();
		System.out.println(productsComparisonPage.getProductsComparisonPageTitle());
		
		
	}
}
