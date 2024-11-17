Feature: Make My Trip 

Background: Validate user is able to click on search button

Given Browser should be launched and url should be navigated and Pop up handled
When User should be able to click on Homestays and villas link
And User should be navigated to Homestays and villas page
When User should be able to click on city lable option
And User should be able to enter city name and select the city name
And User should be able to click on the check-in and select the date
And User should be able to click on the check-out and select the date
And User should be able to click on the Guests and select no of guests 
And User should be able to click on Apply button
And User is able to click on the search button
And User should be navigate to the Banglore properties


Scenario: Validate user is able to Currency Option
Then User is able to click on the INR button
And User is able to choose Indian Rupee option


Scenario: Validate user is able to change the checkout date
Then user is able to click on the check out 
And User is able to change the date and click on apply


Scenario Outline: Validate user able to click on the sort by option
Then selecting <SortOption> should be displayed

Examples:
    | SortOption |
    | 1	|
    | 2	|
    | 3	|
    |	4	|


Scenario: Validate user is able to explore the maps
Then Click on the explore maps Option
And Click on the "+" button to zoom the Location
And Close the Map


Scenario: validate user is able to select the filters for the Property
Then User is able to select the filters for the property
And User is able to navigate to the property


Scenario: Validate user is able to click on the Property
And user is click on the Price(Heightst First) option
Then User is able to click on the property
And user is able to navigate to the next page

