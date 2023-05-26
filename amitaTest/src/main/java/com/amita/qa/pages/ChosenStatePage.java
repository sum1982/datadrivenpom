package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class ChosenStatePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Ascension Illinois Foundation')]")
	@CacheLookup
	WebElement IllinoisFoundationBtn;

	public ChosenStatePage() {
		PageFactory.initElements(driver, this);
	}

	public AscensionFoundationPage IllinoisLink() {
		IllinoisFoundationBtn.click();
		return new AscensionFoundationPage();
	}

}
