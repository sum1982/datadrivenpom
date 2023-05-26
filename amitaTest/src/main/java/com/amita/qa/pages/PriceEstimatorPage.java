package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class PriceEstimatorPage extends TestBase {

	@FindBy(linkText = "Labs")
	@CacheLookup
	WebElement Labsbtn;

	@FindBy(linkText = "Blood")
	@CacheLookup
	WebElement Bloodbtn;

	@FindBy(linkText = "Routine lab testing")
	@CacheLookup
	WebElement Routinelabbtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/div/div[2]/button/div/p[1]")
	@CacheLookup
	WebElement Bloodtestlink;

	@FindBy(id = "searchbar")
	@CacheLookup
	WebElement searchbox;

	@FindBy(xpath = "//p[contains(text(),'AMITA Health St. Alexius Medical Center Hoffman Es')]")
	@CacheLookup
	WebElement hospitalLink;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
	@CacheLookup
	WebElement insuranceselection;

	@FindBy(xpath = "//body/div[@id='menu-']/div[3]/ul[1]/li[5]")
	@CacheLookup
	WebElement selected_insurance;

	@FindBy(xpath = "//*[@id=\"insurance-plan-select\"]")
	WebElement planselection;

	@FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[1]")
	@CacheLookup
	WebElement selected_plan;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/button/span[1]")
	@CacheLookup
	WebElement get_my_estimate;

	public PriceEstimatorPage() {
		PageFactory.initElements(driver, this);
	}

	public PriceEstimatorPage priceEstimatorLink() throws Exception {
		Labsbtn.click();
		Bloodbtn.click();
		Routinelabbtn.click();
		Bloodtestlink.click();
		searchbox.click();
		searchbox.clear();
		searchbox.sendKeys(TestUtil.getpriceTransparencyVO().getZip());
		searchbox.sendKeys(Keys.ENTER);
		hospitalLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")))
				.click();
		selected_insurance.click();
		planselection.click();
		selected_plan.click();
		get_my_estimate.click();
		return new PriceEstimatorPage();
	}
}
