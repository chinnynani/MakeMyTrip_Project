package com.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"com.stepDefinitions","hook"},
features= {"./src/test/resources/featureFiles"},
//tags="@testNG",/
plugin={"rerun:target/rerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"junit:Reports/Cucumber.xml"})
public class parallelRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios() {
		System.setProperty("dataproviderthreadcount", "2");
		return super.scenarios();
	}
}