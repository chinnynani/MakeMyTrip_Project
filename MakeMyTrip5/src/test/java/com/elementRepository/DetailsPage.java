package com.elementRepository;

import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage{

	public DetailsPage(WebDriver driver) {
		super(driver);
	}

	public String expected_Title() {
		return driver.getTitle();
	}
	
	public String actual_Title() {
		return "Omicron Hotel 1 BHK Studio Rooms | Hotel Details Page | MakeMyTrip.com";
	}
	
}
