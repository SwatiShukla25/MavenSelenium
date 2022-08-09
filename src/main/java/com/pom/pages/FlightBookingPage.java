package com.pom.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pom.base.TestBase;

public class FlightBookingPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement flightbooking;
	
	@FindBy(xpath="//tbody/tr[3]/td[2]/b[1]/select")
	WebElement passengerDropDown;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/select")
	 WebElement DepartingDropdown;
	
	@FindBy(xpath = "//tbody/tr[5]/td[2]/select[1]")
	WebElement MonthDropDown;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/select[2]")
	WebElement dateDropDown;
	
	@FindBy(xpath="//tbody/tr[6]/td[2]/select")
	WebElement ArrivingDropdown;
	
	@FindBy(xpath="//tbody/tr[7]/td[2]/select[1]")
	WebElement ReturnMonthDropDown;
	
	@FindBy(xpath="//tbody/tr[7]/td[2]/select[2]")
	WebElement ReturndateDropDown;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement submitbtn;
	
public FlightBookingPage()
{
	PageFactory.initElements(driver, this);
}

public void ValidateSuccessfullFlightBooking() {
	String oneway ="One Way";
	String	radiobtn1="One Way";
	flightbooking.click();
	List<WebElement> oneWayRadioBtn=driver.findElements(By.xpath("//tbody/tr[2]/td[2]/b[1]/font[1]/input[2]"));
	for (int i=0;i<oneWayRadioBtn.size(); i++)

	{
		oneWayRadioBtn.get(i).getText();
	    List radiobtn = Arrays.asList(radiobtn1);
	    		if (radiobtn.contains(oneway))
		{
	    			oneWayRadioBtn.get(i).click();

		}
				}
}
	
	public void ValidatePassengerDropDown()
	{
	Select dropdown = new Select(passengerDropDown);
    dropdown.selectByIndex(1);
	}
	
    public void ValidateDepartingDropdown()
    {
    Select dropdown1 = new Select (DepartingDropdown);
    dropdown1.selectByValue("Paris");
    }
    
    public void ValidateMonthDropDown()
    {
    Select dropdown2 = new Select(MonthDropDown);
    dropdown2.selectByIndex(8);
    }
    
    public void ValidatedateDropDown()
    {
    Select dropdown3 = new Select(dateDropDown);
    dropdown3.selectByValue("21");
    }
    
    public void ValidatedArrivingDropdown()
    {
    Select dropdown4 = new Select (ArrivingDropdown);
    dropdown4.selectByValue("Seattle");
    }
    public void ValidateReturnMonthDropDown()
    {
    Select dropdown5 = new Select(ReturnMonthDropDown);
    dropdown5.selectByIndex(10);
    }
    public void ValidateReturndateDropDown()
    {
    Select dropdown6 = new Select(ReturndateDropDown);
    dropdown6.selectByValue("21"); 
    }
    
    public void ValidateSubmitButton()
    {
    submitbtn.click();
}

public String FlightBookingPageTitle()
{
	return driver.getTitle();
}
}
