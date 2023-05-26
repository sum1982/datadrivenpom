package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class LocationPage extends TestBase {

	@FindBy(xpath = "//a[@title='Find a Location']")
	@CacheLookup
	WebElement FindByLocationBtn;

	@FindBy(xpath = "//div[@class='icon']")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(xpath = "//input[@class='location-input js-search-query']")
	@CacheLookup
	WebElement KeysInputBtn;

	@FindBy(xpath = "//a[contains(text(),'Physical Therapy')]")
	WebElement PhysicalTherapyBtn;

	@FindBy(xpath = "//a[contains(text(),'Ascension Medical Group Illinois - Heart & Vascula')]")
	WebElement wantedLocation;

	public LocationPage() {
		PageFactory.initElements(driver, this);
	}

	public LocationPage clickWantedLockation() throws Exception {
		searchbtn.click();
		KeysInputBtn.sendKeys(TestUtil.locationData().getCitystatezip());
		searchbtn.click();
		PhysicalTherapyBtn.click();
		wantedLocation.click();

		return new LocationPage();
	}

	public String varifyLocationPage() {
		return driver.getTitle();
	}
}