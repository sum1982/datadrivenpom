package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;

public class PostAcuteCarePage extends TestBase {

	public PostAcuteCarePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/div/div[3]/div/div/div/div/div/div/div/p[5]/a")
	@CacheLookup
	WebElement findLocBtn;

	public PostAcuteCarePage clickFindLocaLink() {
		findLocBtn.click();
		return new PostAcuteCarePage();
	}

}
