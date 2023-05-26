package com.amita.qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.MainPage;
import com.amita.qa.pages.PostAcuteCarePage;
import com.amita.qa.pages.SpecialtyCarePage;

public class SpecialtyCareTest extends TestBase {

	MainPage mainPage;
	SpecialtyCarePage specialtyCarePage;
	PostAcuteCarePage postAcuteCarePage;

	public SpecialtyCareTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		mainPage = new MainPage();
		specialtyCarePage = new SpecialtyCarePage();
		postAcuteCarePage = new PostAcuteCarePage();
	}

	@Test()
	public void SpecialtyPageTest() throws Exception {

		String title = mainPage.validateMainpageTitle();
		Assert.assertEquals(title, "Healthcare | Ascension");
		System.out.println(title);
		specialtyCarePage = mainPage.specialtyCareLink();
		specialtyCarePage.PostAcuteCareLink();
		postAcuteCarePage.clickFindLocaLink();
		driver.quit();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
