package com.amita.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.AscensionFoundationPage;
import com.amita.qa.pages.ChosenStatePage;
import com.amita.qa.pages.DonationPage;
import com.amita.qa.pages.MainPage;
import com.amita.qa.pages.MakeAGiftPage;
import com.amita.qa.util.TestUtil;

public class DonationTest extends TestBase {

	MainPage mainPage;
	DonationPage donationPage;
	ChosenStatePage chosenStatePage;
	AscensionFoundationPage ascensionFoundationPage;
	MakeAGiftPage makeAGiftPage;
	TestUtil testUtil;

	public DonationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();// from test base class
		testUtil = new TestUtil();
		mainPage = new MainPage();
		donationPage = new DonationPage();
		chosenStatePage = new ChosenStatePage();
		ascensionFoundationPage = new AscensionFoundationPage();
		makeAGiftPage = new MakeAGiftPage();

	}

	@Test()
	public void DonateTest() throws Exception {
		donationPage = mainPage.DonateLink();
		chosenStatePage = donationPage.clickIllinoisLink();
		ascensionFoundationPage = chosenStatePage.IllinoisLink();
		testUtil.getHandels();
		ascensionFoundationPage.clickMakeAGiftLink();
		makeAGiftPage.donateLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
