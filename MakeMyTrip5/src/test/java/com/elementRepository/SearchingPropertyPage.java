package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchingPropertyPage extends BasePage {

	public SearchingPropertyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@class='react-autosuggest__input']")
	private WebElement searchingTheProperty;

	public WebElement getSearchingTheProperty() {
		return searchingTheProperty;
	}

}
