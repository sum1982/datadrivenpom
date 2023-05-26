package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amita.qa.base.TestBase;
import com.amita.qa.util.TestUtil;

public class EmailPage extends TestBase {

	@FindBy(name = "icims_content_iframe")
	@CacheLookup
	WebElement iframes;

	@FindBy(name = "//*[@id=\"email\"]")
	@CacheLookup
	WebElement emailbox;

	@FindBy(id = "enterEmailSubmitButton")
	@CacheLookup
	WebElement submitbutton;

	public EmailPage() {
		PageFactory.initElements(driver, this);

	}

	public EmailPage emailLink() throws Exception {
		WebElement iframe = driver.findElement(By.xpath("//iFrame[@class=\"wuksD5\"]"));
		driver.switchTo().frame(iframe);
		emailbox.click();
		emailbox.click();
		emailbox.sendKeys(TestUtil.getcareerVO().getEmail());
		return new EmailPage();
	}
}
