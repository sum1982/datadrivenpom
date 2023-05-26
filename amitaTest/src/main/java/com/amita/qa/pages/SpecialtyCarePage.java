package com.amita.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class SpecialtyCarePage extends TestBase {

	@FindBy(name = "get-care-now-filter-location")
	@CacheLookup
	WebElement postAcuteCareBtn;

	@FindBy(linkText = "Post-acute care")
	WebElement postAcuteCareSearch;

	public SpecialtyCarePage() {
		PageFactory.initElements(driver, this);
	}

	public PostAcuteCarePage PostAcuteCareLink() throws Exception {
		postAcuteCareBtn.click();
		postAcuteCareBtn.clear();
		postAcuteCareBtn.sendKeys(TestUtil.getSpecialtyCare().getSearch());
		postAcuteCareSearch.click();

		return new PostAcuteCarePage();
	}

	public String verifySpecialtyCarePage() {
		return driver.getTitle();
	}
}
