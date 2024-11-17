package com.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public PropertyPage goToPropertyPage(WebDriver driver) {
		clickElement(getsearchButton());
		return new PropertyPage(driver);
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
//choosing city	
	@FindBy(id = "city")
	private WebElement cityLink;

	public WebElement getCityLink() {
		return cityLink;
	}

	@FindBy(xpath = "//input[@title='Where do you want to stay?']")
	private WebElement selectCity;

	public WebElement getSelectCity() {
		return selectCity;
	}

// check in date
	@FindBy(id = "checkin")
	private WebElement checkInDropdown;

	public WebElement getCheckInDropdown() {
		return checkInDropdown;
	}

	public WebElement getInDate(WebDriver driver, String month, int date) {
		return driver.findElement(By.xpath("//div[contains(text(),'" + month + "')]/../..//div[contains(@aria-label,'"
				+ month.substring(0, 3) + " " + date + "')]"));
	}

//check out date
	@FindBy(id = "checkout")
	private WebElement checkOutDropdown;

	public WebElement getCheckOutDropdown() {
		return checkOutDropdown;
	}

	public WebElement getOutDate(WebDriver driver, String month1, int date1) {
		return driver.findElement(By.xpath("//div[contains(text(),'" + month1 + "')]/../..//div[contains(@aria-label,'"
				+ month1.substring(0, 3) + " " + date1 + "')]"));
	}

//Guests count selection
	@FindBy(id = "guest")
	private WebElement guestDropdown;

	public WebElement getGuestDropdown() {
		return guestDropdown;
	}
	public void getadultsDropdownClick(WebDriver driver) {
		driver.findElement(By.xpath("(//div[@class='gstSlctCont'])[1]")).click();
	}

	@FindBy(xpath = "//ul[@class='gstSlct__list']/li[3]")
	private WebElement adultscount;

	public WebElement getAdultscount() {
		return adultscount;
	}

//Apply button
	@FindBy(xpath = "//button[@data-cy='RoomsGuestsNew_327']")
	private WebElement applyButton;

	public WebElement getApplyButton() {
		return applyButton;
	}
	@FindBy(xpath="(//div[@class='gstSlctCont'])[1]")
	private WebElement getadultsDropdown;
	
	public WebElement getGetadultsDropdown() {
		return getadultsDropdown;
	}
//search button	
	@FindBy(id = "hsw_search_button")
	private WebElement searchButton;

	public WebElement getsearchButton() {
		return searchButton;
	}
	

}
