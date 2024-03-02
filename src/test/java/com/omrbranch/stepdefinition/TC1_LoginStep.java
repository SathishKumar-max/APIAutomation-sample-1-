package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.globaldata.GlobalDatas;
import com.omrbranch.pojo.login.LogIn_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {

	Response response;
	public static String logtoken;
	static GlobalDatas globalDatas = new GlobalDatas();
	
	@Given("User add Header")
	public void user_add_header() {

		addHeader("accept", "application/json");
	}

	@When("User add Basic Authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {

		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
	}

	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String type) {
		
		response = addReqType(type, EndPoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify the login response code first_Name present as {string} and get the logtoken saved")
	public void user_should_verify_the_login_response_code_first_name_present_as_and_get_the_logtoken_saved(
			String expfirstName) {
		
		LogIn_Output_Pojo logIn_Output_Pojo = response.as(LogIn_Output_Pojo.class);
		String actFirstName = logIn_Output_Pojo.getData().getFirst_name();
		System.out.println(actFirstName);
		logtoken = logIn_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogtoken(logtoken);
		Assert.assertEquals("Verify firstName", expfirstName, actFirstName);

	}

}