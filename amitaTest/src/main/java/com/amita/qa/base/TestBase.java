package com.amita.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.amita.qa.util.TestUtil;
import com.amita.qa.util.WebEventListners;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\kohli\\OneDrive\\Desktop\\Eclipse Work\\amitaTest\\src\\main\\java\\com\\amita\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");

//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("window-size=1400,800");
//			options.addArguments("headless");
//			driver = new ChromeDriver(options);

			driver = new ChromeDriver();

		} else if (browserName.equals("fire")) {
			System.setProperty("webdriver.gecko.driver", "c:\\data\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "c:\\data\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListners();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
