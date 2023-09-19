package com.tutorialNinja.functionalTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;

public class Draft extends InitialComponents {
	String productName = "mac";

	@Test
	public void draftfail()  {
		
		Assert.assertEquals(false, true);
		
	
	}
	
	
	@Test()
	public void liginPagefail() {
		WebDriver driver = setupThreadLocalDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		Assert.assertEquals(driver.getTitle(), productName);
	}
}
	
	
	
	
	
