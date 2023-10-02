package com.tutorialNinja.pageObjectFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.tutorialNinja.base.Reuseables;

public class CommonElements {

	private WebDriver driver;

	public CommonElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/a[@title='Shopping Cart']")
	private WebElement shoppingCartButton;
	@FindBy(xpath = "//footer//div[@class='col-sm-3']//li/a")
	private List<WebElement> footerLinks;
	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='Currency']")
	private WebElement currencyDropDown;
	@FindBy(xpath = "//button[@name='EUR']")
	private WebElement €Euro;
	@FindBy(xpath = "//button[@name='GBP']")
	private WebElement £PoundSterling;
	@FindBy(xpath = "//button[@name='USD']")
	private WebElement $USDollar;
	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement telephone;
	@FindBy(xpath = "//div[@id='logo']//a")
	private WebElement logo;
	@FindBy(xpath = "//input[@name='search'and @class='form-control input-lg']")
	private WebElement searchBox;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']/following-sibling::span")
	private WebElement myAccountDropList;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='Register']")
	private WebElement registerButton;
	@FindBy(xpath= "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='My Account']")
	private WebElement myAccountButton;
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")
	private WebElement loginButton;
	@FindBy(xpath= "//li[@class='dropdown open']//a[text()='Logout']")
	private WebElement accountDropDownLogoutButton;
	@FindBy(xpath= "//span[@id='cart-total']")
	private WebElement totalCartItemsAndPriceButton;
	@FindBy(xpath= "//a[text()='Desktops']")
	private WebElement navBarDesktopDropdownButton;
	@FindBy(xpath= "//li[@class='dropdown open']//a[contains(text(),'PC')]")
	private WebElement navBarDesktopDropdownPC;

	public ShoppingCartPage clickShoppingCartButton() {
		shoppingCartButton.click();
		return new ShoppingCartPage(driver);
	}

	public String getLogoText() {
		return logo.getText();
	}

	public void setText(String productName) {
		searchBox.sendKeys(productName);
	}

	public SearchResultPage clickSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
	}

	public void click_MyAccountDropLisButton() {
		myAccountDropList.click();
	}
	public MyAccountPage click_MyAccount() {
		myAccountButton.click();
		return new MyAccountPage(driver);
	}
	public RegistrationPage click_registerButton() {
		registerButton.click();
		return new RegistrationPage(driver);
	}

	public LoginPage click_LoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}
	public LogOutPage clickAccountDropDownLogoutButton() {
		accountDropDownLogoutButton.click();
		return new LogOutPage(driver);
	}

	public List<WebElement> getAllFooterLinks() {
		return footerLinks;
	}

	public void click_CurrencyDropDown() {
		currencyDropDown.click();
	}

	public void select_Currency_€Euro() {
		€Euro.click();
	}

	public void select_Currency_£Pound() {
		£PoundSterling.click();
	}

	public void select_Currency_$USDollar() {
		$USDollar.click();
	}

	public void click_telephone() {
		telephone.click();
	}
	
	public void clickTotalCartItemsAndPriceButton() {
		totalCartItemsAndPriceButton.click();
	}
	
	public void clickNavBarDesktopDropdownButton() {
		navBarDesktopDropdownButton.click();
	}
	public ProductCatagoryPage clickNavBarDesktopDropdownPC() {
		navBarDesktopDropdownPC.click();
		return new ProductCatagoryPage(driver);
	}

	public void validateAllFooterLinks(WebDriver driver) {
		
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//div[@class='col-sm-3']//li/a"));
		byte count = 1;
		for (Iterator<WebElement> iterator = footerLinks.iterator(); iterator.hasNext();) {
			WebElement webElement = iterator.next();
			String link = webElement.getAttribute("href");
			int responseCode = 0;
			try {
				responseCode = new Reuseables().getURLresponseCode(link);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (responseCode > 200) {
				softAssert.assertTrue(false);
			} else {
				System.out.println(count + ": " + link + " responseCode= " + responseCode + ", is valid");
				softAssert.assertTrue(true);
			}
			count++;
		}
	}

}
