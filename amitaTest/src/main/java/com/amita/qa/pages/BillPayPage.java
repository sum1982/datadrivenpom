package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class BillPayPage extends TestBase {

	@FindBy(linkText = "PAY A HOSPITAL BILL - VISITPAY PORTAL")
	@CacheLookup
	WebElement Pay_A_HospitalBtn;

	public BillPayPage() {
		PageFactory.initElements(driver, this);

	}

	public PayHospitalPage PayHospitalLink() {
		Pay_A_HospitalBtn.click();
		return new PayHospitalPage();
	}

	public String verifyBillPayPage() {
		return driver.getTitle();
	}
}