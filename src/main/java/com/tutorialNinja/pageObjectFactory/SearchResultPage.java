package com.tutorialNinja.pageObjectFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends CommonElements{

	private WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement searchText;
	@FindBy(xpath = "//div[@class='caption']/h4/a")
	private List<WebElement> listOfSearchedProducts;
	@FindBy(xpath= "//div[@class='product-thumb']//button[@data-original-title='Compare this Product']")
	private List<WebElement> listOfCompareButton;
	@FindBy(xpath= "//a[text()='product comparison']")
	private WebElement comparisonLinkButton;
	@FindBy(xpath= "//div[@class='product-thumb']")
	private List<WebElement> allSearchProducts;

	public String getSearchedItemText() {
		return searchText.getText();
	}

	public ProductDetailsPage click_DesiredProduct(String expectedProductName) {
		for (WebElement e : listOfSearchedProducts) {
			if (e.getText().contains(expectedProductName)) {
				e.click();
				break;
			}
		}
		return new ProductDetailsPage(driver);
	}
	
	public ProductsComparisonPage click_productCompareButton(String expectedProductName) {
		for(WebElement e : allSearchProducts) {
			if(e.findElement(By.xpath("//div[@class='caption']/h4/a")).getText().contains(expectedProductName)) {
				e.findElement(By.xpath("//button[@data-original-title='Compare this Product']")).click();;
				break;
			}
		}
		return new ProductsComparisonPage(driver);
	}
	
	public ProductsComparisonPage click_comparisonLinkButton() {
		 comparisonLinkButton.click();
		 return new ProductsComparisonPage(driver);
	}
}
