
Feature: Feature to test login and Book a Flight functionality of the application.


Background:

Given Launched NewTours Demo login page

  Scenario: Check login is successful with valid login credentials.
    
    When User enters valid User Name and Password
    And User clicked on Submit button
    Then User successfully logged in to the home page

	Scenario: Check User is able to book a flight.
	

	When Click on Flights to book a flight
	And Enter details to book flight
	Then User successfully booked flight

	