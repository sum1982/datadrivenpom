package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amita.qa.base.TestBase;

public class AscensionFoundationPage extends TestBase {

	@FindBy(xpath = "//*[@id=\\\"comp-l8ep9eh1\\\"]/a/div/span[1]")
	@CacheLookup
	WebElement MakeAGiftBtn;

	public AscensionFoundationPage() {
		PageFactory.initElements(driver, this);
	}

	public MakeAGiftPage clickMakeAGiftLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"comp-l8ep9eh1\"]/a/div/span[1]")))
				.click();
//		MakeAGiftBtn.click();
		return new MakeAGiftPage();
	}
}
