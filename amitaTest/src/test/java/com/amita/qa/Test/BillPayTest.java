package com.amita.qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amita.qa.base.TestBase;
import com.amita.qa.pages.BillPayPage;
import com.amita.qa.pages.GuestPage;
import com.amita.qa.pages.MainPage;
import com.amita.qa.pages.PayHospitalPage;
import com.amita.qa.util.TestUtil;

public class BillPayTest extends TestBase {

	MainPage mainPage;
	BillPayPage billPayPage;
	PayHospitalPage payHospitalPage;
	GuestPage guestPage;
	TestUtil testUtil;

	String sheetName = "Sheet1";

	public BillPayTest() {
		super();// you have to call test base class constructor to use intialization();
	}

	@BeforeMethod
	public void setUp() {
		intialization();// from test base class
		testUtil = new TestUtil();// from test base class
		mainPage = new MainPage();
		billPayPage = new BillPayPage();
		payHospitalPage = new PayHospitalPage();
		guestPage = new GuestPage();

	}

	@Test()
	public void BillPayPageTest() throws Exception {
		String title = mainPage.validateMainpageTitle();
		Assert.assertEquals(title, "Healthcare | Ascension", "Main page Title not correct");
		System.out.println("title1" + title);
		billPayPage = mainPage.billPayLink();
		String title1 = billPayPage.verifyBillPayPage();
		Assert.assertEquals(title1, "Billing and payment | Ascension", "Billing and payment Title not correct");
		System.out.println("title2" + title1);
		billPayPage.PayHospitalLink();
		testUtil.getHandels();

		payHospitalPage.MakeOneTimePaymentLink();
		String title2 = payHospitalPage.verifyPayHospitalPage();
		Assert.assertEquals(title2, "Ascension", "PayHospital Title not correct");
		System.out.println("title3" + title2);
		guestPage.fillForm();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
