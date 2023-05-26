package com.amita.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amita.qa.base.TestBase;
import com.amita.qa.testdata.AmitaVO1;
import com.amita.qa.testdata.CareerVO;
import com.amita.qa.testdata.DonationVO;
import com.amita.qa.testdata.LocationVO;
import com.amita.qa.testdata.PriceTransparencyVO;
import com.amita.qa.testdata.SpecialtyCareVO;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public void getHandels() {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();// may change import type

		String parentWindowId = it.next();
//	        System.out.println("parent window id"+parentWindowId);

		String childWindowId = it.next();
//	        System.out.println("child window id"+childWindowId);

		driver.switchTo().window(childWindowId);
		System.out.println("chid window Title" + driver.getTitle());
	}

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static AmitaVO1 getData1() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet secondSheet = workbook.getSheetAt(1);
		for (int i = 1; i <= 6; i++) {
			Row r = secondSheet.getRow(0);
			Cell c = r.getCell(i);
			String user = c.getStringCellValue();
			r = secondSheet.getRow(1);
			c = r.getCell(i);
			String lastname = c.getStringCellValue();
			r = secondSheet.getRow(2);
			c = r.getCell(i);
			String dob = c.getStringCellValue();
			r = secondSheet.getRow(3);
			c = r.getCell(i);
			String doby = c.getStringCellValue();
			r = secondSheet.getRow(4);
			c = r.getCell(i);
			String pdob = c.getStringCellValue();
			r = secondSheet.getRow(5);
			c = r.getCell(i);
			String pdoby = c.getStringCellValue();

			AmitaVO1 amitaVO1 = new AmitaVO1(user, lastname, dob, doby, pdob, pdoby);

			System.out.println(amitaVO1);

			inputStream.close();

			return amitaVO1;

		}
		return null;
	}

	public static LocationVO locationData() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));

		Workbook workbook = new XSSFWorkbook(inputStream);
		// getting first worksheet
		Sheet firstSheet = workbook.getSheetAt(0);
		// get first row
		Row r = firstSheet.getRow(0); // first row
		Cell c = r.getCell(1); // username value
		String citystatezip = c.getStringCellValue();

		LocationVO locationVO = new LocationVO(citystatezip);

		System.out.println(locationVO);

		inputStream.close();

		return locationVO;

	}

	public static SpecialtyCareVO getSpecialtyCare() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Row r = firstSheet.getRow(1); // first row
		Cell c = r.getCell(1); // username value
		String search = c.getStringCellValue();
		SpecialtyCareVO specialtyCareVO = new SpecialtyCareVO(search);
		System.out.println(specialtyCareVO);
		inputStream.close();

		return specialtyCareVO;

	}

	public static DonationVO getdonationVO() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Row r = firstSheet.getRow(2); // first row
		Cell c = r.getCell(1); // username value
		String donation_amount = c.getStringCellValue();
		DonationVO donationVO = new DonationVO(donation_amount);
		System.out.println(donationVO);
		inputStream.close();

		return donationVO;

	}

	public static PriceTransparencyVO getpriceTransparencyVO() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Row r = firstSheet.getRow(3); // first row
		Cell c = r.getCell(1); // username value
		String zip = c.getStringCellValue();
		PriceTransparencyVO priceTransparencyVO = new PriceTransparencyVO(zip);
		System.out.println(priceTransparencyVO);
		inputStream.close();
		return priceTransparencyVO;

	}

	public static CareerVO getcareerVO() throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Row r = firstSheet.getRow(4); // first row
		Cell c = r.getCell(1); // username value
		String keyword = c.getStringCellValue();
		Row r1 = firstSheet.getRow(5); // first row
		Cell c1 = r.getCell(1); // username value
		String zipcode = c.getStringCellValue();
		Row r2 = firstSheet.getRow(6); // first row
		Cell c2 = r.getCell(1); // username value
		String email = c.getStringCellValue();
		CareerVO careerVO = new CareerVO(keyword, zipcode, email);
		System.out.println(careerVO);
		inputStream.close();
		return careerVO;

	}
}
