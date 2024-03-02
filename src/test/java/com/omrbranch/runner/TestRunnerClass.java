package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = ("@Login or @State or @City or @Address or @searchproduct"), features = "src/test/resources/Features", glue = "com.omrbranch.stepdefinition", stepNotifications = true, plugin = {
		"pretty", "json:target\\omr.json" }, dryRun = false, monochrome = true)
public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void afterClass() {

		// Reporting.generatedJVMReporting(+ getPropertyFileValue("jsonpath"));
		Reporting.generatedJVMReporting("E:\\GreensSelenium\\OMRBranchGroceryAPIAutomation\\target\\omr.json");
	}
}
