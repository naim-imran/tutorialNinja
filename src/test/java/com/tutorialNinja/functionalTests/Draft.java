package com.tutorialNinja.functionalTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialNinja.base.InitialComponents;
import com.tutorialNinja.pageObjectFactory.HomePageObjects;
import com.tutorialNinja.pageObjectFactory.ProductCatagoryPage;

public class Draft extends InitialComponents {
	String sheetName = "Customer";
/////
	@Test(groups = {"possitive"},description = "negetive test case draftfail")
	public void draftfail() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.click_CurrencyDropDown();
		Assert.assertEquals(false, true);

	}
	
	@Test(groups = {"negetive"}, description = "negetive test case loginPagefail")
	public void loginPagefail() {
		WebDriver driver = setupThreadLocalDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		Assert.assertEquals(driver.getTitle(), sheetName);
		
	}

	@Test(description = "validate readExcelDraft")
	public void readExcelDraft() {
		Object[][] data = readExcelData(sheetName);
		System.out.println(data.length);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		Properties prop = loadProperty();
		System.out.println(prop.get("browser"));
		// Assert.assertEquals(false, true);

		ArrayList<HashMap<String, Object>> dataList = readExcelData();
		for (Iterator<HashMap<String, Object>> iterator = dataList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> hashMap = (HashMap<String, Object>) iterator.next();
			// Iterate through the entries and print keys and values
			for (Entry<String, Object> entry : hashMap.entrySet()) {
				String key = entry.getKey();
				String value = (String) entry.getValue();
				System.out.println("Key: " + key + ", Value: " + value);
			}
			System.out.println();

		}

	}
	
	@Test(description = "click on homepage featured product")
	public void testHomepageFeaturedProduct() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.clickHomePageFeaturedProduct("Canon EOS 5D");
	}
	
	@Test(description = "draft test of product catagory page")
	public void testHomePageNav() {
		HomePageObjects homePage = launchApplicationHomePage();
		homePage.clickNavBarDesktopDropdownButton();
		ProductCatagoryPage catagoryPage = homePage.clickNavBarDesktopDropdownPC();
		Assert.assertEquals(catagoryPage.getProductCatagoryPageTitle(), "PC");
	}
}
