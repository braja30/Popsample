package com.popmoney.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.popmoney.constance.Constance;
import com.popmoney.page_objects.Home_Page;
import com.popmoney.page_objects.PreLogin_page;
import com.popmoney.page_objects.SearchBank_page;
import com.popmoney.page_objects.SignUp_page;
import com.popmoney.utilities.CommonUtiles;
import com.popmoney.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_Step_definition {

		
	private static final Logger LOGGER = LogManager.getLogger(SignUp_Step_definition.class);

	@Given("The user landed in home page and enter email or phone number, click get started")
	public void the_user_oggined_in_successfuly_and_is_on_on_home_page() throws InterruptedException {
		try {
			DriverManager.getDriver().get(Constance.APP_URL);
			DriverManager.getDriver().manage().window().maximize();

			Home_Page.getInstance().enterEmail(Constance.EMAIL);
			Home_Page.getInstance().clickStart();
			String url = DriverManager.getDriver().getCurrentUrl();
			 System.out.println(url);
			if (url.contains("searchBank")) {
				LOGGER.info("The user landed in home page and enter email or phone number, click get started");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtiles.getInstance().takeScreenshot();
		}

	}

	@When("Select {string} and submit")
	public void select_and_submit(String bankName) throws InterruptedException {
		try {
			SearchBank_page.getInstance().bankSelection(bankName);
			String url = DriverManager.getDriver().getCurrentUrl();
			 System.out.println(url);
			if (url.contains("prelogin")) {
				LOGGER.info("Select Ally Bank and submit");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtiles.getInstance().takeScreenshot();
		}

	}

	@When("Enter First name ,last name and click Next")
	public void enter_first_name_last_name_email_and_click_next() throws InterruptedException {
		try {
			PreLogin_page.getInstance().enterFirstname(Constance.FIRSTNAME);
			PreLogin_page.getInstance().enterLastname(Constance.LASTNAME);
			PreLogin_page.getInstance().switchToreCaptchaFrame();	
			PreLogin_page.getInstance().clickreCaptcha();
			Thread.sleep(9000);
			PreLogin_page.getInstance().switchToDc();
			PreLogin_page.getInstance().clickreNext();

			String url = DriverManager.getDriver().getCurrentUrl();
			 System.out.println(url);
			if (url.contains("signup")) {
				LOGGER.info("Enter First name ,last name and click Next");
			}
		}

		catch (Exception e) {
			LOGGER.error(e);
			CommonUtiles.getInstance().takeScreenshot();
		}

	}

	@When("Enter all required information for profile creation,select state as {string} from dropdown by using {string} and click SignUp")
	public void enter_all_required_information_for_profile_creation_select_state_as_from_dropdown_by_using_and_click_sign_up(
			String value, String howTo) {

		try {
			SignUp_page.getInstance().enterPhoneNo(Constance.PHONE_NUMBER);
			SignUp_page.getInstance().enterPassword(Constance.PASSWORD);
			SignUp_page.getInstance().enterRePassword(Constance.PASSWORD);
			SignUp_page.getInstance().clickBussinesscheck();
			Thread.sleep(2000);
			SignUp_page.getInstance().enterBussinessName(Constance.BUSINESS_NAME);
			SignUp_page.getInstance().enterAddress1(Constance.ADDRESS_1);
			SignUp_page.getInstance().enterCity(Constance.CITY);
			Thread.sleep(2000);
			CommonUtiles.getInstance().selectFromDropDown(SignUp_page.getInstance().getSTATE(), howTo, value);
			SignUp_page.getInstance().enterZip(Constance.ZIP);
			SignUp_page.getInstance().enterBirthMonth(Constance.BIRTH_MONTH);
			SignUp_page.getInstance().enterBirthDay(Constance.BIRTH_DAY);
			SignUp_page.getInstance().enterBirthyear(Constance.BIRHT_YEAR);
			SignUp_page.getInstance().clickPolicy();
//			SignUp_page.getInstance().clickSignUp();

			LOGGER.info("Enter all required information for create a profile page and click SignUp");
		}

		catch (Exception e) {
			LOGGER.error(e);
			CommonUtiles.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("The user should see the welcome message as per signUp firstname")
	public void the_user_should_see_the_welcome_message_as_per_sign_up_firstname() {
		try {
			String url = DriverManager.getDriver().getCurrentUrl();
			// System.out.println(url);
			if (url.contains(Constance.FIRSTNAME)) {
				LOGGER.info("The user should see the welcome message as per signUp firstname");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtiles.getInstance().takeScreenshot();
		}

	}
}