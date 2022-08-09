package com.pom.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.FlightBookingPage;
import com.pom.pages.LoginPage;

public class FlightBookingPageTest extends TestBase {
	
	FlightBookingPage flightbooking;
	LoginPage loginP;
	
	public FlightBookingPageTest() {
		super();
	}
	
	@BeforeClass
public void setUp()
{
	initialization();
	flightbooking = new FlightBookingPage();
	loginP = new LoginPage();
	loginP.login(prop.getProperty("userName"), prop.getProperty("password"));
	
	}
	
	@Test()
	public void SuccessfullFlightBookingTest() {
		flightbooking.FlightBookingPageTitle();
		flightbooking.ValidateSuccessfullFlightBooking();
		flightbooking.ValidatePassengerDropDown();
		flightbooking.ValidateDepartingDropdown();
		flightbooking.ValidateMonthDropDown();
		flightbooking.ValidatedateDropDown();
		flightbooking.ValidatedArrivingDropdown();
		flightbooking.ValidateReturnMonthDropDown();
		flightbooking.ValidateReturndateDropDown();
		flightbooking.ValidateSubmitButton();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
