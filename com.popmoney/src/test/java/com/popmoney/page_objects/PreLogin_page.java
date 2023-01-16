package com.popmoney.page_objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.popmoney.utilities.CommonUtiles;
import com.popmoney.webdriver_manager.DriverManager;

public class PreLogin_page {

	WebDriver driver = DriverManager.getDriver();
	private static final Logger LOGGER = LogManager.getLogger();
	private static PreLogin_page PreLoginPageInstance;

	private PreLogin_page() {

	}

	public static PreLogin_page getInstance() {
		if (PreLoginPageInstance == null) {
			PreLoginPageInstance = new PreLogin_page();
		}
		return PreLoginPageInstance;
	}

	@FindBy(id = "main-form:firstname:firstname")
	private WebElement FIRSTNAME;

	@FindBy(id = "main-form:lastname:lastname")
	private WebElement LASTNAME;

//	@FindBy(xpath = "//*[@id=\"reCaptchaElement\"]/div/div/iframe")
//	private WebElement reCAPTCHA_FRAME;

	// in page factroy @find by method not able to use explicit wait , so here v
	// take it by locator method

	By reCAPTCHA_FRAME = By.xpath("//*[@id=\"reCaptchaElement\"]/div/div/iframe");

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
	private WebElement reCAPTCHA;

	@FindBy(id = "main-form:nextButton")
	private WebElement NEXT;

//	public  WebElement getFIRSTNAME() {
//		return FIRSTNAME;
//	}
//
//	public  WebElement getLASTNAME() {
//		return LASTNAME;
//	}
//
//	public  WebElement getReCAPTCHA_FRAME() {
//		return reCAPTCHA_FRAME;
//	}
//
//	public  WebElement getReCAPTCHA() {
//		return reCAPTCHA;
//	}
//
//	public  WebElement getNEXT() {
//		return NEXT;
//	}

	public void enterFirstname(String firstname) {
		CommonUtiles.getInstance().highLightElement(FIRSTNAME);
		FIRSTNAME.sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		CommonUtiles.getInstance().highLightElement(LASTNAME);
		LASTNAME.sendKeys(lastname);
	}

	public void switchToreCaptchaFrame() {
		try {
			driver.switchTo().frame(driver.findElement(reCAPTCHA_FRAME));
		} catch (Exception e) {
			LOGGER.info("Element not found.Trying to find it one more time using explicit wait");
		}
		try {
			// CommonUtiles.getInstance().explicitWait(driver.findElement(reCAPTCHA_FRAME), 20);
		} catch (Exception e) {
			LOGGER.info("Element not found.Please check the locator used");
		}
	}

	public void clickreCaptcha() {
		CommonUtiles.getInstance().highLightElement(reCAPTCHA);
		reCAPTCHA.click();
	}

	public void switchToDc() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	public void clickreNext() {
		CommonUtiles.getInstance().highLightElement(NEXT);
		NEXT.click();
	}

}
