package com.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public HomePage goToHomePage(WebDriver driver) {
		clickElement(getHomestaysAndVillasLink());
		return new HomePage(driver);
	}

//click element
	public void clickElement(WebElement element) {
		element.click();
	}

//pop up handling	
	@FindBy(xpath = "//span[@data-cy='closeModal']")
	private WebElement homePopUp;

	public WebElement getHomePopUp() {
		return homePopUp;
	}

//Url	
	@FindBy(xpath = "//span[text()='Homestays & Villas'][1]")
	private WebElement homestaysAndVillasLink;
	

	public WebElement getHomestaysAndVillasLink() {
		return homestaysAndVillasLink;
	}

}
