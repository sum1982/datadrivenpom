package com.amita.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amita.qa.base.TestBase;

public class PriceTransparencyPage extends TestBase {

	@FindBy(linkText = "//a[contains(text(),'Estimate my price')]")
	WebElement priceEstimatorbtn;

	public PriceTransparencyPage() {
		PageFactory.initElements(driver, this);
	}

	public PriceEstimatorPage priceEstimatorLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebDriverWait wait = new WebDriverWait(driver, 20); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Estimate my price')]")))
				.click();

		return new PriceEstimatorPage();
	}
}
