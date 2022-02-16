package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
		plugin = {//report
				"html:target/report/cucumber.html",
				"json:target/cucumber.json"
				
		},
		
		features = {"src/main/resources/OrbitzLogin.feature"}, //path
		glue = {"com.cucumber.stepdef"} //stepdef package name
		
		
	)

public class RunnerFile extends AbstractTestNGCucumberTests {

}
