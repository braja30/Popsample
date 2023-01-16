package com.popmoney.step_definitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.popmoney.utilities.CommonUtiles;
import com.popmoney.webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_step_definition {

	private static String scenarioName = null;

	public static String getscenarioName() {
		return scenarioName;
	}
	
	private static final Logger LOGGER = LogManager.getLogger(Common_step_definition.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("******************Execution Started ********************************");
		try {
			scenarioName = scenario.getName();
			LOGGER.info("Instantiation the CommonUtiles");

			LOGGER.info("Loading the load properties");
			CommonUtiles.getInstance().loadproperties();
			LOGGER.info("Checking the driver is NULL or NOT?");
			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is NULL ,Instantiating it!");

				DriverManager.launchbrowser();
				CommonUtiles.getInstance().initWeblements();
				DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				DriverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
