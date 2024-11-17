package com.elementRepository;

import org.openqa.selenium.WebDriver;

public class BookingPage extends BasePage{

	public BookingPage(WebDriver driver) {
		super(driver);
	}
	
	public String expected_Title() {
		return driver.getTitle();
	}
	
	public String actual_Title() {
		return "Professionals Pride | Hotel Details Page | MakeMyTrip.com";
	}
}
