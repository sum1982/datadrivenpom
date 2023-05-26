package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class PayHospitalPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Make a one-time payment')]")
	@CacheLookup
	WebElement MakeOneTimePaymentBtn;

	public PayHospitalPage() {
		PageFactory.initElements(driver, this);
	}

	public GuestPage MakeOneTimePaymentLink() {
		MakeOneTimePaymentBtn.click();
		return new GuestPage();
	}

	public String verifyPayHospitalPage() {
		return driver.getTitle();
	}
}
