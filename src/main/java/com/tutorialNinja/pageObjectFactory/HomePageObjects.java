package com.tutorialNinja.pageObjectFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinja.base.Reuseables;

public class HomePageObjects extends Reuseables {
	
	private WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

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
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")
	private WebElement loginButton;

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

	public void click_MyAccount() {
		myAccountDropList.click();
	}

	public RegistrationPage click_registerButton() {
		registerButton.click();
		return new RegistrationPage(driver);
	}

	public LoginPage click_LoginButton() {
		loginButton.click();
		return new LoginPage(driver);
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

	public void validateHomePageFooterLinks() {
		validateAllFooterLinks(driver);
	}

}
