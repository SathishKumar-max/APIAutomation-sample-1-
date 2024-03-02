package com.omrbranch.stepdefinition;

import io.cucumber.java.en.*;

public class CommonStep {

	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expStatusCode) {
		
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		//Assert.assertEquals(actStatusCode, expStatusCode);
		org.junit.Assert.assertEquals("", expStatusCode, actStatusCode);
		
	}
}
