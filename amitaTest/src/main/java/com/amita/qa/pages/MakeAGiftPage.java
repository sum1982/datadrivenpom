package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class MakeAGiftPage extends TestBase {

//	WebElement iframe = driver.findElement
	@FindBy(xpath = "//iFrame[@class=\"wuksD5\"]")
	WebElement iframe;

	@FindBy(xpath = "//*[@id=\"bboxdonation_gift_rdlstGivingLevels\"]/div[6]/div/label/span")
	@CacheLookup
	WebElement donationlink;

	@FindBy(xpath = "//input[@name='bboxdonation$gift$txtOtherAmountButtons']")
	@CacheLookup
	WebElement donationBox;

	public MakeAGiftPage() {
		PageFactory.initElements(driver, this);
	}

	public MakeAGiftPage donateLink() throws Exception {
		WebElement iframe = driver.findElement(By.xpath("//iFrame[@class=\"wuksD5\"]"));
		driver.switchTo().frame(iframe);
		donationlink.click();
		donationBox.sendKeys(TestUtil.getdonationVO().getDonation());
		return new MakeAGiftPage();
	}
}
