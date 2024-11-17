package com.stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.BasePage;
import com.elementRepository.HomePage;
import com.elementRepository.PropertyPage;
import com.elementRepository.SearchingPropertyPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;
import com.utilityClasses.WebDriverUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeMyTripClass {

	WebDriverUtility webDriverUtility = new WebDriverUtility();
	WebDriver driver = DriverFactory.getDriver();
	BasePage basePage = new BasePage(driver);
	HomePage homePage;
	PropertyPage propertyPage;
	SearchingPropertyPage searchingPropertyPage;
	FileUtility fileUtility = new FileUtility();
	Actions actions = new Actions(driver);

	@Given("Browser should be launched and url should be navigated and Pop up handled")
	public void browser_should_be_launched_and_url_should_be_navigated_and_pop_up_handled() throws Exception {
		basePage.clickElement(basePage.getHomePopUp());
		Reporter.log("Pop up handled", true);
		String url = fileUtility.getDataFromExcel("Sheet6", 0, 0);
		Assert.assertEquals(driver.getCurrentUrl(), url);
		Reporter.log("Browser Launched", true);
	}

	@When("User should be able to click on Homestays and villas link")
	public void user_should_be_able_to_click_on_homestays_and_villas_link() throws Exception {
		String title = fileUtility.getDataFromExcel("Sheet6", 2, 0);
		Assert.assertTrue(basePage.getHomestaysAndVillasLink().isDisplayed(), title);
		basePage.clickElement(basePage.getHomestaysAndVillasLink());
		Reporter.log("User clicked the Homestays and villas link", true);
	}

	@When("User should be navigated to Homestays and villas page")
	public void user_should_be_navigated_to_homestays_and_villas_page() throws Exception {
		String url = fileUtility.getDataFromExcel("Sheet6", 1, 0);
		Assert.assertEquals(driver.getCurrentUrl(), url);
		Reporter.log("User is navigated to Homestays and villas page", true);
	}

	@When("User should be able to click on city lable option")
	public void user_should_be_able_to_click_on_city_lable_option() {
		homePage = basePage.goToHomePage(driver);
		Reporter.log("User is able to select the city lable option", true);
	}

	@When("User should be able to enter city name and select the city name")
	public void user_should_be_able_to_enter_city_name_and_select_the_city_name() throws Exception {
		homePage.clickElement(homePage.getCityLink());
		WebElement cityname = homePage.getSelectCity();
		webDriverUtility.waitForElementPresent(driver, cityname);
		String city = fileUtility.getDataFromExcel("Sheet3", 0, 0);
		cityname.sendKeys(city);
		fileUtility.thread();
		cityname.sendKeys(Keys.ARROW_DOWN + "" + Keys.ENTER);
		Reporter.log("User is able to set the city name", true);
	}

	@When("User should be able to click on the check-in and select the date")
	public void user_should_be_able_to_click_on_the_check_in_and_select_the_date() throws Exception {
		String month = fileUtility.getDataFromExcel("Sheet2", 0, 0);
		int date = fileUtility.getNumericalDataFromExcel("Sheet2", 0, 1);
		WebElement checkInDate = homePage.getInDate(driver, month, date);
		homePage.clickElement(checkInDate);
		Reporter.log("User selected the check in date", true);
		fileUtility.thread();
	}

	@When("User should be able to click on the check-out and select the date")
	public void user_should_be_able_to_click_on_the_check_out_and_select_the_date() throws Exception {
		String month = fileUtility.getDataFromExcel("Sheet2", 1, 0);
		int date = fileUtility.getNumericalDataFromExcel("Sheet2", 1, 1);
		WebElement checkOutDate = homePage.getOutDate(driver, month, date);
		homePage.clickElement(checkOutDate);
		Reporter.log("User is able to click on check out option", true);
	}

	@When("User should be able to click on the Guests and select no of guests")
	public void user_should_be_able_to_click_on_the_guests_and_select_no_of_guests() throws InterruptedException {
		homePage.clickElement(homePage.getGuestDropdown());
		fileUtility.thread();
		homePage.clickElement(homePage.getGetadultsDropdown());
		fileUtility.thread();
		homePage.clickElement(homePage.getAdultscount());
		fileUtility.thread();
		Reporter.log("User selected the check out date", true);
	}

	@When("User should be able to click on Apply button")
	public void user_should_be_able_to_click_on_apply_button() throws InterruptedException {
		homePage.clickElement(homePage.getApplyButton());
		fileUtility.thread();
		Reporter.log("user clicks the apply button", true);
	}

	@When("User is able to click on the search button")
	public void user_is_able_to_click_on_the_search_button() throws Exception {
		propertyPage = homePage.goToPropertyPage(driver);
		String title = fileUtility.getDataFromExcel("Sheet6", 3, 0);
		fileUtility.thread();
		webDriverUtility.switchToTabOnTitle(driver, title);
		Reporter.log("user is clicks the search button", true);
	}

	@When("User should be navigate to the Banglore properties")
	public void user_should_be_navigate_to_the_banglore_properties() throws Exception {
		String title = fileUtility.getDataFromExcel("Sheet6", 3, 0);
		Assert.assertEquals(driver.getTitle(), title);
		Reporter.log("user navigates to the banglore properties page", true);
	}

	@Then("User is able to click on the INR button")
	public void user_is_able_to_click_on_the_inr_button() {
		propertyPage.clickElement(propertyPage.getInrButton());
		Reporter.log("User is able to click on the INR button", true);
	}

	@Then("User is able to choose Indian Rupee option")
	public void user_is_able_to_choose_indian_rupee_option() throws Exception {
		propertyPage.clickElement(propertyPage.getIndianRupeeOption());
		WebElement currency = propertyPage.getIndianRupeeOption();
		webDriverUtility.waitForElementPresent(driver, currency);
		String currencyType = fileUtility.getDataFromExcel("Sheet4", 0, 0);
		currency.sendKeys(currencyType);
		currency.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER).perform();
		Reporter.log("User is able to choose Indian Rupee option", true);
	}

	@Then("user is able to click on the check out")
	public void user_is_able_to_click_on_the_check_out() throws InterruptedException {
		propertyPage.clickElement(propertyPage.getChangeCheckOutOption());
		Reporter.log("User clicked the check out option", true);
	}

	@Then("User is able to change the date and click on apply")
	public void user_is_able_to_change_the_date_and_click_on_apply() throws Exception {
		int date = fileUtility.getNumericalDataFromExcel("Sheet2", 2, 1);
		WebElement checkOutDate = propertyPage.getDate(driver, date);
		propertyPage.clickElement(checkOutDate);
		Reporter.log("User upadated the check out date");
		propertyPage.clickElement(propertyPage.getAgainClickApply());
	}

	@Then("selecting {int} should be displayed")
	public void selecting_should_be_displayed(Integer SortOption) throws Exception {

		String sortoption = fileUtility.getDataFromExcel("Sheet1", SortOption - 1, 0);

		switch (sortoption) {
		case "Popular":
			propertyPage.clickElement(propertyPage.getSortByOption_Popular());
			String appliedSortOptionPopular = propertyPage.getActiveSortOptionForPopular();
			Assert.assertEquals(appliedSortOptionPopular, "Popular", "Popular sort option should be selected");
			Reporter.log("Popular option selected", true);
			break;

		case "Rating":
			propertyPage.clickElement(propertyPage.getSortByOption_Rating());
			String appliedSortOptionRating = propertyPage.getActiveSortOptionForRating();
			Assert.assertEquals(appliedSortOptionRating, "User Rating (Highest First)",
					"Rating sort option should be selected");
			Reporter.log("Rating option selected", true);
			break;

		case "Price (Highest First)":
			propertyPage.clickElement(propertyPage.getSortByOption_PriceHeighestFirst());
			String appliedSortOptionHigh = propertyPage.getActiveSortOptionForHighest();
			Assert.assertEquals(appliedSortOptionHigh, "Price (Highest First)",
					"Price (Highest First) sort option should be selected");
			Reporter.log("Price (Highest First) option selected", true);
			break;

		case "Price (Lowest First)":
			propertyPage.clickElement(propertyPage.getSortByOption_PriceLowestFirst());
			String appliedSortOptionLow = propertyPage.getActiveSortOptionForLowest();
			Assert.assertEquals(appliedSortOptionLow, "Price (Lowest First)",
					"Price (Lowest First) sort option should be selected");
			Reporter.log("Price (Lowest First) option selected", true);
			break;
		}
	}

	@Then("Click on the explore maps Option")
	public void click_on_the_explore_maps_option() {
		propertyPage.clickElement(propertyPage.getExploreMap());
		Reporter.log("User clicked on the Explore Maps option", true);
		WebElement mapView = propertyPage.getSearchText();
		Assert.assertTrue(mapView.isDisplayed(), "Map view is not displayed");
		Reporter.log("Map view is displayed", true);
	}

	@Then("Click on the {string} button to zoom the Location")
	public void click_on_the_button_to_zoom_the_location(String string) throws InterruptedException {
		propertyPage.clickElement(propertyPage.getClickPlus());
		propertyPage.clickElement(propertyPage.getClickPlus());
		Reporter.log("User seen the location", true);
	}

	@Then("Close the Map")
	public void close_the_map() {
		propertyPage.clickElement(propertyPage.getCloseMap());
		WebElement back = propertyPage.getReturnBack();
		Assert.assertTrue(back.isDisplayed(), "Map not Closed");
		Reporter.log("Closed the map", true);
	}

	@Then("User is able to select the filters for the property")
	public void user_is_able_to_select_the_filters_for_the_property() throws InterruptedException {
		webDriverUtility.scrollToPosition(driver, 0, 1100);
		propertyPage.clickElement(propertyPage.getChoosingBedroomOption());
		fileUtility.thread();
		webDriverUtility.scrollToPosition(driver, 0, 900);
		propertyPage.clickElement(propertyPage.getChoosingPropertyTypeOption());
		propertyPage.clickElement(propertyPage.getChoosingProperty());
		fileUtility.thread();
	}

	@Then("User is able to navigate to the property")
	public void user_is_able_to_navigate_to_the_property() {
		Reporter.log("User navigated to the Searching Property");

	}

	@When("user is click on the Price\\(Heightst First) option")
	public void user_is_click_on_the_price_heightst_first_option() {
		propertyPage.clickElement(propertyPage.getSortByOption_PriceLowestFirst());
		Reporter.log("Price option selected", true);
	}

	@Then("User is able to click on the property")
	public void user_is_able_to_click_on_the_property() throws InterruptedException {
		propertyPage.clickElement(propertyPage.getProperty());
		fileUtility.thread();
		Reporter.log("User clicked the property", true);
	}

	@Then("user is able to navigate to the next page")
	public void user_is_able_to_navigate_to_the_next_page() {
		Reporter.log("user is navigated to the next page", true);
	}

}
