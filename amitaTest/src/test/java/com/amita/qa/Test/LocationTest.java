package com.amita.qa.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.LocationPage;
import com.amita.qa.pages.MainPage;

public class LocationTest extends TestBase {

	MainPage mainPage;
	LocationPage locationPage;

	public LocationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		mainPage = new MainPage();
		locationPage = new LocationPage();

	}

	// @Test(priority = 1)
	public void mainPageTitleTest() {
		String title = mainPage.validateMainpageTitle();
		Assert.assertEquals(title, "Healthcare | Ascension");
		driver.quit();
	}

	// @Test(priority = 2)
	public void logoTest() {
		boolean flag = mainPage.validateascensionLogo();
		Assert.assertTrue(flag);
		driver.quit();
	}

	@Test(priority = 3)
	public void LocationPageTest() throws Exception {

		String title = mainPage.validateMainpageTitle();
		Assert.assertEquals(title, "Healthcare | Ascension");
		System.out.println(title);
		locationPage = mainPage.locationLink();
		String title1 = locationPage.varifyLocationPage();
		Assert.assertEquals(title1, "Find a Location | Ascension", "Location page title not matched");
		locationPage.clickWantedLockation();
		System.out.println(title1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		String title2 = locationPage.varifyLocationPage();
		Assert.assertEquals(title2, "Ascension Medical Group Illinois - Heart & Vascular Care Bartlett | Ascension",
				"Result page title not matched");
		System.out.println(title2);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
