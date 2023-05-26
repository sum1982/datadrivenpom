package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class MainPage extends TestBase {

	// Page Factory
	@FindBy(xpath = "//a[@title='Find a Location']")
	@CacheLookup
	WebElement locationBtn;

	@FindBy(xpath = "//header/div[@id='header']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")
	@CacheLookup
	WebElement ascensionLogo;

	@FindBy(xpath = "//a[@href='/billing']")
	@CacheLookup
	WebElement billPaybtn;

	@FindBy(xpath = "//div[@class='field-heading']")
	@CacheLookup
	WebElement specialtyCarebtn;

	@FindBy(xpath = "//header/div[@id='header']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]")
	@CacheLookup
	WebElement donatebtn;

	@FindBy(linkText = "Price Transparency")
	@CacheLookup
	WebElement priceTransparencybtn;

	@FindBy(linkText = "Careers")
	@CacheLookup
	WebElement careersbtn;

	public MainPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateMainpageTitle() {
		return driver.getTitle();
	}

	public boolean validateascensionLogo() {
		return ascensionLogo.isDisplayed();
	}

	public LocationPage locationLink() {
		locationBtn.click();
		return new LocationPage();
	}

	public BillPayPage billPayLink() {
		billPaybtn.click();
		return new BillPayPage();
	}

	public SpecialtyCarePage specialtyCareLink() {
		specialtyCarebtn.click();
		return new SpecialtyCarePage();
	}

	public DonationPage DonateLink() {
		donatebtn.click();
		return new DonationPage();
	}

	public PriceTransparencyPage priceTransparencyLink() {
		priceTransparencybtn.click();
		return new PriceTransparencyPage();
	}

	public CareersPage careerLink() {
		careersbtn.click();
		return new CareersPage();
	}

}
