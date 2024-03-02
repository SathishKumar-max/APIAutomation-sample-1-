package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generatedJVMReporting(String jsonFile){
		
		//1, Mention the path of the Jvm report where to store
		
		File file = new File("E:\\GreensSelenium\\OMRBranchGroceryAPIAutomation\\target");
		
		//2,Create object for configuration
		
		Configuration configuration = new Configuration(file, "OMRBranchGroceryAPIAutomation");

		//3, Browser, author, testng, sprint, version
		
		configuration.addClassifications("", "");
		configuration.addClassifications("", "");
		configuration.addClassifications("", "");
		
		//4, Create the object for ReportBuilder class--->Json files
		
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		
		//5, Generate Report
		
		builder.generateReports();
		
		
	}
}
