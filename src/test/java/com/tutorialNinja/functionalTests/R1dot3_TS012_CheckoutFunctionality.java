package com.tutorialNinja.functionalTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.ShoppingCartPage;

public class R1dot3_TS012_CheckoutFunctionality extends InitialComponents {
	
	@Test(description = "R1.3_TS012_TC001 Verify navigating to Checkout page when there are no products added to the Shopping Cart")
	public void R1dot3_TS012_TC001(){
		HomePageObjects homePage = launchApplicationHomePage();
		ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartButton();
		Assert.assertEquals(shoppingCartPage.getShoppingCartPageTitle(), "Shopping Cart");
		
		 
	}
}
