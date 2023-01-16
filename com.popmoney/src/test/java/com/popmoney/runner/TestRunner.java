package com.popmoney.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//html:target/cucumber-reports/report.html
//json:target/cucumber-reports/report.json
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.popmoney.step_definitions",
		dryRun = false,
		monochrome = true,
		plugin = {"rerun:target/failed_scenario.txt",
				"html:target/cucumber-reports/report.html"},
		publish = true
		
		)

public class TestRunner {

}
