package com.amita.qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.CareersPage;
import com.amita.qa.pages.EmailPage;
import com.amita.qa.pages.JobsPage;
import com.amita.qa.pages.MainPage;
import com.amita.qa.util.TestUtil;

public class CareerTest extends TestBase {

	MainPage mainPage;
	CareersPage careersPage;
	JobsPage jobsPage;
	EmailPage emailPage;
	TestUtil testUtil;

	@BeforeMethod
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		mainPage = new MainPage();
		jobsPage = new JobsPage();
		emailPage = new EmailPage();
	}

	@Test()
	public void CareerPageTest() throws Exception {
		String title = mainPage.validateMainpageTitle();
		Assert.assertEquals(title, "Healthcare | Ascension", "Main page Title not correct");
		System.out.println("title1" + title);
		careersPage = mainPage.careerLink();

		String title1 = mainPage.validateMainpageTitle();
		Assert.assertEquals(title1, "Join Ascension Careers | Make a Difference");
		System.out.println("title2" + title1);
		careersPage.jobsLink();
		jobsPage.applyLink();

		emailPage.emailLink();
		String title2 = mainPage.validateMainpageTitle();
		Assert.assertEquals(title2, "iCIMS Careers Portal");
		System.out.println("title2" + title2);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}