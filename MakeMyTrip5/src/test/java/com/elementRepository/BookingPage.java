package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage {

	public BookingPage(WebDriver driver) {
		super(driver);
	}

//	public AgreementPage goToAgreementPage(WebDriver driver) {
//		clickElement(getAgreement());
//		return new AgreementPage(driver);
//	}

	public void clickElement(WebElement element) {
		element.click();
	}


//
//	@FindBy(xpath = "//a[@href='https://www.makemytrip.com/legal/in/eng/user_agreement.html#1']")
//	private WebElement agreement;
//
//	public WebElement getAgreement() {
//		return agreement;
//	}

}
