package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class GuestPage extends TestBase {

	@FindBy(id = "AuthenticationId0")
	@CacheLookup
	WebElement AccountBtn;

	@FindBy(id = "LastName")
	@CacheLookup
	WebElement LastNameBtn;

	@FindBy(id = "DateOfBirthDay")
	@CacheLookup
	WebElement DateOfBirthDayBtn;

	@FindBy(id = "DateOfBirthYear")
	@CacheLookup
	WebElement DateOfBirthYearBtn;

	@FindBy(id = "PatientDateOfBirthDay")
	WebElement PatientDateOfBirthDayBtn;

	@FindBy(id = "PatientDateOfBirthYear")
	@CacheLookup
	WebElement PatientDateOfBirthYearBtn;

	@FindBy(xpath = "//label[@id='rbNotPatientLabel']")
	@CacheLookup
	WebElement notPatientBtn;

	@FindBy(xpath = "//label[@id='GuestPayAgreeTermsOfUseLabel']")
	@CacheLookup
	WebElement agreeToTermBtn;

	@FindBy(id = "guestAuthenticationSubmitButton")
	@CacheLookup
	WebElement continuBtn;

	public void fillForm() throws Exception {

		AccountBtn.click();
		AccountBtn.sendKeys(TestUtil.getData1().getUser());
		LastNameBtn.click();
		LastNameBtn.sendKeys(TestUtil.getData1().getLastname());
		DateOfBirthDayBtn.click();
		DateOfBirthDayBtn.sendKeys(TestUtil.getData1().getDob());
		DateOfBirthYearBtn.click();
		DateOfBirthYearBtn.sendKeys(TestUtil.getData1().getDoby());
		Select mon = new Select(driver.findElement(By.id("DateOfBirthMonth")));
		mon.selectByVisibleText("Jan");
		notPatientBtn.click();
		PatientDateOfBirthDayBtn.click();
		PatientDateOfBirthDayBtn.sendKeys(TestUtil.getData1().getPdob());
		PatientDateOfBirthYearBtn.click();
		PatientDateOfBirthYearBtn.sendKeys(TestUtil.getData1().getPdoby());
		Select month = new Select(driver.findElement(By.id("PatientDateOfBirthMonth")));
		month.selectByVisibleText("Jul");

	}

//	public void select_month() {
//		Select mon = new Select(driver.findElement(By.id("DateOfBirthMonth")));
//		mon.selectByVisibleText("Jan");
//	}

	public GuestPage notAPatientLink() {
		notPatientBtn.click();
		return new GuestPage();
	}

	public GuestPage continuBtnLink() {
		agreeToTermBtn.click();
		continuBtn.click();
		return new GuestPage();
	}

	public String verifyGuestPage() {
		return driver.getTitle();
	}

	public GuestPage() {
		PageFactory.initElements(driver, this);
	}
}
