package com.popmoney.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.popmoney.constance.Constance;
import com.popmoney.page_objects.Home_Page;
import com.popmoney.page_objects.PreLogin_page;
import com.popmoney.page_objects.SearchBank_page;
import com.popmoney.page_objects.SignUp_page;
import com.popmoney.step_definitions.Common_step_definition;
import com.popmoney.webdriver_manager.DriverManager;

public class CommonUtiles {

	private static final Logger LOGGER = LogManager.getLogger(CommonUtiles.getInstance());

	private static CommonUtiles commonUtilesInstance = null;

	private CommonUtiles() {
	}
	public static CommonUtiles getInstance() {
		if (commonUtilesInstance == null) {
			commonUtilesInstance = new CommonUtiles();
		}
		return commonUtilesInstance;
	}

	public void loadproperties() throws IOException {

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Constance.APP_URL = properties.getProperty("APP_URL");
		Constance.BROWSER = properties.getProperty("BROWSER");
		Constance.EMAIL = properties.getProperty("EMAIL");
		Constance.FIRSTNAME = properties.getProperty("FIRSTNAME");
		Constance.LASTNAME = properties.getProperty("LASTNAME");
		Constance.PHONE_NUMBER = properties.getProperty("PHONE_NUMBER");
		Constance.BUSINESS_NAME = properties.getProperty("BUSINESS_NAME");
		Constance.ADDRESS_1 = properties.getProperty("ADDRESS_1");
		Constance.CITY = properties.getProperty("CITY");
		Constance.STATE = properties.getProperty("STATE");
		Constance.ZIP = properties.getProperty("ZIP");
		Constance.BIRTH_MONTH = properties.getProperty("BIRTH_MONTH");
		Constance.BIRTH_DAY = properties.getProperty("BIRTH_DAY");
		Constance.BIRHT_YEAR = properties.getProperty("BIRHT_YEAR");
		Constance.PASSWORD = properties.getProperty("PASSWORD");

		// Constance.CHROME_DRIVER_LOCATION=properties.getProperty("CHROME_DRIVER_LOCATION");
	}

	public void initWeblements() {
		PageFactory.initElements(DriverManager.getDriver(), Home_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SearchBank_page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), PreLogin_page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SignUp_page.getInstance());
	}

	public void takeScreenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_step_definition.getscenarioName() + ".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void highLightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

	public void selectFromDropDown(WebElement dropDown, String howTo, String value) {
		Select select = new Select(dropDown);
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
		default:
			LOGGER.info("Please provide valid selection in feature file. Valid selections are: text, value, index");
			break;
		}
	}
	public void explicitWait(WebElement element, int i) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
