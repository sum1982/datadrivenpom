package com.amita.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class JobsPage extends TestBase {

	@FindBy(linkText = "//a[@id='link-apply-0']/span/span")
	@CacheLookup
	WebElement applyBtn;

	public JobsPage() {
		PageFactory.initElements(driver, this);

	}

	public EmailPage applyLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		applyBtn.click();
		return new EmailPage();
	}

}