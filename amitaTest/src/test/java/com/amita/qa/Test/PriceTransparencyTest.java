package com.amita.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.MainPage;
import com.amita.qa.pages.PriceEstimatorPage;
import com.amita.qa.pages.PriceTransparencyPage;
import com.amita.qa.util.TestUtil;

public class PriceTransparencyTest extends TestBase {

	MainPage mainPage;
	PriceTransparencyPage priceTransparencyPage;
	PriceEstimatorPage priceEstimatorPage;
	TestUtil testUtil;

	public PriceTransparencyTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		mainPage = new MainPage();
		priceTransparencyPage = new PriceTransparencyPage();
		priceEstimatorPage = new PriceEstimatorPage();
	}

	@Test()
	public void PriceTransparencyPageTest() throws Exception {
		priceTransparencyPage = mainPage.priceTransparencyLink();
		priceEstimatorPage = priceTransparencyPage.priceEstimatorLink();
		testUtil.getHandels();
		priceEstimatorPage.priceEstimatorLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
