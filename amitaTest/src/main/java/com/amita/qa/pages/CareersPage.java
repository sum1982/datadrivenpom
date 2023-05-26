package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class CareersPage extends TestBase {

	@FindBy(id = "keyword-search")
	@CacheLookup
	WebElement keyword_searhbtn;

	@FindBy(id = "location-search")
	@CacheLookup
	WebElement locationbtn;

	@FindBy(xpath = "//div[@id='all-content']/div[3]/light-search/lw-search/div/div/div/div/form/div[3]/button/span")
	@CacheLookup
	WebElement submitbtn;

	public CareersPage() {
		PageFactory.initElements(driver, this);
	}

	public JobsPage jobsLink() throws Exception {
		keyword_searhbtn.click();
		keyword_searhbtn.clear();
		keyword_searhbtn.sendKeys(TestUtil.getcareerVO().getKeyword());
		locationbtn.click();
		locationbtn.clear();
		locationbtn.sendKeys(TestUtil.getcareerVO().getZipcode());
		submitbtn.click();
		return new JobsPage();
	}
}
