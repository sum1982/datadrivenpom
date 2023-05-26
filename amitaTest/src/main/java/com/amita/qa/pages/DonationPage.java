package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class DonationPage extends TestBase {

	@FindBy(xpath = "//h3[contains(text(),'Illinois')]")
	@CacheLookup
	WebElement IllinoisBtn;

	public DonationPage() {
		PageFactory.initElements(driver, this);
	}

	public ChosenStatePage clickIllinoisLink() {
		IllinoisBtn.click();
		return new ChosenStatePage();
	}
}
